package QuanLyNV;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("===================MENU===================");
        System.out.println("1. Nhap du lieu cho bang DonVi");
        System.out.println("2. Nhap du lieu cho bang NhanVien");
        System.out.println("3. In danh dach DonVi");
        System.out.println("4. In danh sach NhanVien");
        System.out.println("5. Xoa 1 hang trong bang NhanVien");
        System.out.println("6. Chinh sua 1 hang trong bang NhanVien");
        System.out.println("===================END===================");
        int luachon;
        while(true) {
            System.out.println("\nNhap lua chon: ");
            luachon = sc.nextInt();
            if (luachon == 1) {
                System.out.println("\n\t\tNhap du lieu cho bang DonVi");
                String MaDV, TenDV, c;
                c = sc.nextLine();
                System.out.println("\nNhap vao Ma DV: ");
                MaDV = sc.nextLine();
                System.out.println("\nNhap vao Ten DV: ");
                TenDV = sc.nextLine();
                int rs = DonVI.createDonVi(MaDV, TenDV);
                System.out.println("Co " + rs + " dong bi thay doi");
            }
            else if (luachon == 2) {
                System.out.println("\n\t\tNhap du lieu cho bang NhanVien");
                String MaNV, HoTen, NgaySinh, GioiTinh, MaDV, c;
                float HSL;
                c = sc.nextLine();
                System.out.println("\nNhap vao Ma NV: ");
                MaNV = sc.nextLine();
                System.out.println("\nNhap vao Ho va ten: ");
                HoTen = sc.nextLine();
                System.out.println("\nNhap vao Ngay sinh: ");
                NgaySinh = sc.nextLine();
                System.out.println("\nNhap vao Gioi tinh: ");
                GioiTinh = sc.nextLine();
                System.out.println("\nNhap vao HSL: ");
                HSL = sc.nextFloat();
                System.out.println("\nNhap vao Ma DV: ");
                MaDV = sc.nextLine();
                int rs = NhanVien.createNhanVien(MaNV, HoTen, NgaySinh, GioiTinh, HSL, MaDV);
                System.out.println("Co " + rs + " dong bi thay doi");
            }
            else if (luachon == 3) {
                List<DonVI> ls = DonVI.getListDonVi();
                for (DonVI item : ls) {
                    System.out.println(item.toString());
                }
            }
            else if (luachon == 4) {
                List<NhanVien> ls = NhanVien.getListNhanVien();
                for (NhanVien item : ls) {
                    System.out.println(item.toString());
                }
            }
            else if (luachon == 5) {
                String MaNV;
                System.out.println("\nNhap vao Ma NV: ");
                MaNV = sc.nextLine();
                int rs = NhanVien.DeleteNhanVien(MaNV);
                System.out.println("Co " + rs + " dong bi thay doi");
            }
            else if (luachon == 6){
                String MaNV;
                System.out.println("\nNhap vao Ma NV: "); MaNV = sc.nextLine();
                float HSL;
                System.out.println("\nNhap vao HSL: "); HSL = sc.nextFloat();
                int rs= NhanVien.UpdateNhanVien(MaNV, HSL);
                System.out.println("Co "+rs+" dong bi thay doi");
            }
            else if(luachon == 7){
                String MaNV;
                System.out.println("\nNhap vao Ma NV: "); MaNV = sc.nextLine();
                List<NhanVien> ls = NhanVien.Timkiem(MaNV);
                for(NhanVien item : ls){
                    System.out.println(item.toString());
                }
            }
            else {
                break;
            }
        }
    }
}
