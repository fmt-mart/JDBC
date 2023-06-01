package QLSanPham;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoaiSP {
    private String Maloai;
    private String Tenloai;

    public LoaiSP(String maloai, String tenloai) {
        Maloai = maloai;
        Tenloai = tenloai;
    }

    public String getMaloai() {
        return Maloai;
    }

    public void setMaloai(String maloai) {
        Maloai = maloai;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String tenloai) {
        Tenloai = tenloai;
    }

    @Override
    public String toString() {
        return "LoaiSP=[" + "Ma loai: " + Maloai + ", TenLoai: " + Tenloai + "]";
    }

    public static List<LoaiSP> getListLoaiSP() throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from LoaiSP";
        ResultSet rs = statement.executeQuery(sql);
        List<LoaiSP> ls = new ArrayList<>();
        while(rs.next()){
            String maloai = rs.getString("Maloai");
            String tenloai = rs.getString("Tenloai");
            ls.add(new LoaiSP(maloai,tenloai));
        }
        con.close();
        return ls;
    }

    public static int createLoaiSP(String maloai, String tenloai) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "insert into LoaiSP(maloai,tenloai) values ('"+maloai+"', '"+tenloai+"')";
        int rs = statement.executeUpdate(sql);
        con.close();
        return rs;
    }


}
