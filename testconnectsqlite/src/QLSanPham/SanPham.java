package QLSanPham;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SanPham {
    private String MaSP;
    private String TenSP;
    private int DonGia;

    public SanPham(String maSP, String tenSP, int donGia) {
        MaSP = maSP;
        TenSP = tenSP;
        DonGia = donGia;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    @Override
    public String toString() {
        return "SanPham=[" + "MaSP: " + MaSP + ", TenSP: " + TenSP + ", DonGia: " + DonGia + "]";
    }

    public static List<SanPham> getListSanPham() throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from SanPham";
        ResultSet rs = statement.executeQuery(sql);
        List<SanPham> ls = new ArrayList<>();
        while(rs.next()){
            String masp = rs.getString("MaSP");
            String tensp = rs.getString("TenSP");
            int dongia = rs.getInt("DonGia");
            ls.add(new SanPham(masp, tensp, dongia));
        }
        con.close();
        return ls;
    }
    public static int createSanPham(String maSP, String tenSP, int donGia) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "insert into SanPham(maSP, tenSP, donGia) values ('"+maSP+"', '"+tenSP+"', "+donGia+")";
        int rs = statement.executeUpdate(sql);
        con.close();
        return rs;
    }
}
