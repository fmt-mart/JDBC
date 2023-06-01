package QuanLyNV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVien {
    private String MaNV;
    private String HoTen;
    private String NgaySinh;
    private String GioiTinh;
    private float HSL;
    private String MaDV;

    public NhanVien(String maNV, String hoTen, String ngaySinh, String gioiTinh, float HSl, String maDV) {
        MaNV = maNV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        this.HSL = HSl;
        MaDV = maDV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public double getHSL() {
        return HSL;
    }

    public void setHSl(float HSl) {
        this.HSL = HSl;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String maDV) {
        MaDV = maDV;
    }

    @Override
    public String toString() {
        return "NhanVien = [MaNV: " + MaNV + ", HoTen: " + HoTen + ", NgaySinh: " + NgaySinh + ", GioiTinh: " + GioiTinh
                + ", HSL: " + HSL + ", MaDV: " + MaDV + "]";
    }

    public static List<NhanVien> getListNhanVien() throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from NhanVien";
        ResultSet rs = statement.executeQuery(sql);
        List<NhanVien> ls = new ArrayList<>();
        while(rs.next()){
            String MaNV = rs.getString("MaNV");
            String HoTen = rs.getString("HoTen");
            String NgaySinh = rs.getString("NgaySinh");
            String GioiTinh = rs.getString("GioiTinh");
            float HSL = rs.getFloat("HSL");
            String MaDV = rs.getString("MaDV");
            ls.add(new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, HSL, MaDV));
        }
        con.close();
        return ls;
    }

    public static int createNhanVien(String maNV, String hoTen, String ngaySinh, String gioiTinh, float HSl, String maDV)
            throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "insert into NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, HSL, MaDV)" +
                " values ('"+maNV+"', '"+hoTen+"', '"+ngaySinh+"', '"+gioiTinh+"', "+HSl+", '"+maDV+"')";
        int rs = statement.executeUpdate(sql);
        con.close();
        return rs;
    }

    public static int DeleteNhanVien(String maNV) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "delete from NhanVien where MaNV = '"+maNV+"'";
        int rs = statement.executeUpdate(sql);
        con.close();
        return rs;
    }

    public static int UpdateNhanVien(String maNV, float hsl) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "(update NhanVien set MaNV = '"+maNV+"' where HSL = "+hsl+")";
        int rs = statement.executeUpdate(sql);
        con.close();
        return rs;
    }

    public static List<NhanVien> Timkiem(String maNV) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from NhanVien where MaNV = '"+maNV+"'";
        ResultSet rs = statement.executeQuery(sql);
        List<NhanVien> ls = new ArrayList<>();
        while(rs.next()){
            String MaNV = rs.getString("MaNV");
            String HoTen = rs.getString("HoTen");
            String NgaySinh = rs.getString("NgaySinh");
            String GioiTinh = rs.getString("GioiTinh");
            float HSL = rs.getFloat("HSL");
            String MaDV = rs.getString("MaDV");
            ls.add(new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, HSL, MaDV));
        }
        con.close();
        return ls;
    }
}
