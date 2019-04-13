package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa;password=55555");
//            System.out.println("Kết nối thàng công");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
        return connection;
    }
    public static void main(String[] args) {
//        System.out.println(getConnection());
        
//        LoaiDao dao = new LoaiDao();
//        for(LoaiBean ds : dao.getListLoai()) {
//            System.out.println(ds.getMaLoai() + " - - "+ ds.getTenLoai());
//        }
        
//        SachDao dao = new SachDao();
//        for(SachBean s : dao.getListSachByLoai("Khoa hoc")) {
//            System.out.println(s.getMaSach() + " - " + s.getTenSach());
//        }
//        SachDao dao = new SachDao();
//          System.out.println(dao.getSach("b11").getTenSach());
    }
}
