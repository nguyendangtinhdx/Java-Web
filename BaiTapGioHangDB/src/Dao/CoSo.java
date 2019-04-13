package Dao;
import java.sql.*;
public class CoSo {
    public Connection con;
    
    public void KetNoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa; password=55555");
        /*    System.out.println("Đã kết nối");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getBang(String tb) {
        try {
            String sql = "SELECT * FROM " + tb;
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();// thực hiện câu lệnh truy vấn

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getSachByLoai(String maLoai) {
        try {
            String sql = "SELECT TOP(6) * FROM sach WHERE maloai = '" + maLoai + "'  ORDER BY NgayNhap DESC  ";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();// thực hiện câu lệnh truy vấn

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
