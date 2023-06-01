package QuanLyNV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DonVI {
    private String MaDV;
    private String TenDV;

    public DonVI(String maDV, String tenDV) {
        MaDV = maDV;
        TenDV = tenDV;
    }

    @Override
    public String toString() {
        return "DonVi = [MaDV: " + MaDV + ", TenDV: " + TenDV + "]";
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String maDV) {
        MaDV = maDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String tenDV) {
        TenDV = tenDV;
    }

    public static List<DonVI> getListDonVi() throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from DonVi";
        ResultSet rs = statement.executeQuery(sql);
        List<DonVI> ls = new ArrayList<>();
        while(rs.next()){
            String MaDV = rs.getString("MaDV");
            String TenDV = rs.getString("TenDV");
            ls.add(new DonVI(MaDV, TenDV));
        }
        con.close();
        return ls;
    }

    public static int createDonVi(String maDV, String tenDV) throws SQLException, ClassNotFoundException {
        Connection con = BaseConnectDB.getConnection();
        Statement statement = con.createStatement();
        String sql = "insert into DonVi(MaDV, TenDV) values ('"+maDV+"', '"+tenDV+"')";
        int rs = statement.executeUpdate(sql);
        con.close();
        return rs;
    }
}
