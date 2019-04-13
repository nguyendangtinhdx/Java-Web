package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=FPTBaiTapJavaNangCaoQuanLyCuaHang;user=sa;password=55555");
//            System.out.println("Kết nối thàng công");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
        return connection;
    }
}
