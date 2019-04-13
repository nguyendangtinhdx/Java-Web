package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.AdminBean;

public class AdminDao {
    public ArrayList<AdminBean> getListAdmin(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DangNhap ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<AdminBean> list = new ArrayList<>();
            while(rs.next()) {
                AdminBean admin = new AdminBean();
                admin.setTenDanhNhap(rs.getString("TenDangNhap"));
                admin.setMatKhau(rs.getString("MatKhau"));
                admin.setQuyen(rs.getInt("Quyen"));
                list.add(admin);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean themTaiKhoan(AdminBean a) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO DangNhap VALUES(?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getTenDanhNhap());
            ps.setString(2, a.getMatKhau());
            ps.setInt(3, a.getQuyen());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaTaiKhoan(AdminBean a) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE DangNhap SET MatKhau = ?, Quyen = ? WHERE TenDangNhap = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getMatKhau());
            ps.setInt(2, a.getQuyen());
            ps.setString(3, a.getTenDanhNhap());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaTaiKhoan(String tenDangNhap) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM DangNhap WHERE TenDangNhap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public AdminBean dangNhap(String tenDangNhap, String matKhau) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DangNhap WHERE TenDangNhap = ? AND MatKhau = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                AdminBean admin = new AdminBean();
                admin.setTenDanhNhap(rs.getString("TenDangNhap"));
                admin.setMatKhau(rs.getString("MatKhau"));
                admin.setQuyen(rs.getInt("Quyen"));
                connection.close();
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}
