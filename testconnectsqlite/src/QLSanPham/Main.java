package QLSanPham;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //tao phan tu cho bang LoaiSP
//        int rs = LoaiSP.createLoaiSP("BK", "Banh keo");
//        System.out.println("Co " + rs + " dong bi thay doi");

        //in danh sach bang LoaiSP
//        List<LoaiSP> ls = LoaiSP.getListLoaiSP();
//        for(LoaiSP item : ls) {
//            System.out.println(item.toString());
//        }

        //tao phan tu cho bang SanPham
//        int rs = SanPham.createSanPham("BK", "Banh keo", 11000);
//        System.out.println("Co " + rs + " dong bi thay doi");

        //in danh sach bang SanPham
        List<SanPham> ls = SanPham.getListSanPham();
        for(SanPham item : ls){
            System.out.println(item.toString());
        }
    }
}
