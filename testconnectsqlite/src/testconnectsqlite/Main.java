package testconnectsqlite;
import java.util.*;
//import java.sql.*;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

//public class Database {
//	static Connection conn = null;
//
//	public static void main(String[] args) {
//		//cai dat JDBC cua sqlite
//		try {
//			Class.forName("org.sqlite.JDBC");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//lay ket noi
//		try {
//			conn = DriverManager.getConnection("jdbc:sqlite:Nhom10.db");
//			if (conn != null) {
//				System.err.println("Connected");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		//lay du lieu
//		PreparedStatement preparedStatement;
//		try {
//			preparedStatement = conn.prepareStatement("SELECT*FROM HOCSINH");
//			ResultSet resultset = preparedStatement.executeQuery();
//			while (resultset.next() == true) {
//				int id = resultset.getInt(1);
//				String name = resultset.getString(2);
//
//				System.out.println(". " + id + " / " + name);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		//in danh sach Category
		 List<Category> ls = Category.getListCategory();
		 for(Category item : ls){
		 	System.out.println(item.toString());
		 }

		//tao phan tu Category
//      	int rs=Category.createCategory("Thanh", 4);
//		System.out.println("Co " + rs + " dong bi thay doi");

//		update phan tu category
//		int rs = Category.editCategory("Hieu", 5);
//		System.out.println("Co " + rs + " dong bi thay doi");
		//xoa phan tu Category
//		int rs = Category.deleteCategory(3);
//		System.out.println("Co " + rs + " dong bi thay doi");
	}
}
