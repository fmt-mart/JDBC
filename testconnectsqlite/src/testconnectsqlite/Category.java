package testconnectsqlite;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int ID;
    private String Name;

    public Category(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Category[" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ']';
    }

    public static List<Category> getListCategory() throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();//tao ket noi voi database
        Statement state = con.createStatement();//tao cau lenh sql
        String sql = "SELECT * FROM Category ORDER BY ID,Name ASC";//viet cau lenh
        ResultSet rs = state.executeQuery(sql);//in ket qua
        List<Category> ls = new ArrayList<>();//tao 1 danh sach
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            ls.add(new Category(id,name));
        }
        con.close();
        return ls;
    }
    public static int createCategory(String name, int id) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement state = con.createStatement();
        String sql = "INSERT INTO Category(Name,ID) VALUES ('"+name+"',"+id+")";
        int rs = state.executeUpdate(sql);
        con.close();
        return rs;
    }
    public static int editCategory(String name, int id) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement state = con.createStatement();
        List<Category> ls = Category.getListCategory();
        for(Category item : ls){
            if(item.ID==id){
                String sql="UPDATE Category\n +" +
                        "SET Name='"+name+"'\n" +
                        "WHERE ID=" + id;
                int rs = state.executeUpdate(sql);
                con.close();
                return rs;
            }
        }
        con.close();
        return 0;
    }
    public static int deleteCategory(int id) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement state = con.createStatement();
        List<Category> ls = Category.getListCategory();
        for(Category item : ls){
            if(item.ID==id){
                List<Product> lspd=Product.getListProductOfCategory(id);
                    if (lspd.size() == 0) {
                        String sql = "delete from Category\n" +
                                "where id = " + id;
                        int rs = state.executeUpdate(sql);
                        con.close();
                        return rs;
                    }
                    return -1;
                }
            }
        con.close();
        return 0;
    }
}
