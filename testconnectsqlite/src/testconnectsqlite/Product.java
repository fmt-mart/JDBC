package testconnectsqlite;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Product {
    private int ID;
    private String Name;
    private int Price;
    private int Quantity;
    private int IDCategory;

    public Product(int ID, String name, int price, int quantity, int IDCategory) {
        this.ID = ID;
        Name = name;
        Price = price;
        Quantity = quantity;
        this.IDCategory = IDCategory;
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

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getIDCategory() {
        return IDCategory;
    }

    public void setIDCategory(int IDCategory) {
        this.IDCategory = IDCategory;
    }

    @Override
    public String toString() {
        return "Product [ID=" + ID + ", Name=" + Name + ", Price=" + Price + ", Quantity=" + Quantity
                + ", IDCategoly=" + IDCategory + "]";
    }
    public static List<Product>getListProduct() throws SQLException, ClassNotFoundException {
        Connection con=BaseConnectDB.getConnection();
        Statement state=con.createStatement();
        String sql="SELECT * FROM Product";
        ResultSet rs=state.executeQuery(sql);
        List<Product> ls=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("ID");
            String name=rs.getString("Name");
            int price=rs.getInt("Price");
            int quantity=rs.getInt("Quantity");
            int idcategory=rs.getInt("IDCategory");
            ls.add(new Product(id,name,price,quantity,idcategory));
        }
        con.close();
        return ls;
    }
    public static int createProduct(String name, int price, int quantity, int idcategory) throws SQLException, ClassNotFoundException {
        Connection con=BaseConnectDB.getConnection();
        Statement state=con.createStatement();
        List<Product> ls=Product.getListProduct();
        for(Product item : ls){
            if(item.Name.equals(name)){
                con.close();
                return 0;
            }
        }
        String sql="INSERT INTO Product (Name, Price, Quantity, IDCategory)\n" +
                "VALUES ('"+name+"',"+price+","+quantity+","+idcategory+")";
        int rs=state.executeUpdate(sql);
        con.close();
        return rs;
    }
    public static List<Product> getListProductOfCategory(int idct) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement state = con.createStatement();
        String sql = "select P.ID, P.Name, P.Price, P.Quantity, P.IDCategory\n" +
                "from Product as P inner join Category as C\n" +
                "on P.IDCategory = P.ID\n" +
                "where P.IDCaegory = "+idct+"\n" +
                "order by P.Price DESC";
        ResultSet rs = state.executeQuery(sql);
        List<Product> ls = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            int price = rs.getInt("Price");
            int quantity = rs.getInt("Quantity");
            int idquantity = rs.getInt("IDCategory");
            ls.add(new Product(id,name,price,quantity,idquantity));
        }
        con.close();
        return ls;
    }
    public static boolean checkProductNameExist(int id, String name) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement state = con.createStatement();
        List<Product> lspd = Product.getListProduct();
        for(Product item : lspd){
            if(item.Name.equals(name)){
                return true;
            }
        }
        return false;
    }
}
