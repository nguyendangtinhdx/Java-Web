package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.KhachHangBean;

public class KhachHangDao {
    public boolean checkTaiKhoan(String tenDangNhap) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM KhachHang WHERE tendn = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean dangKy(KhachHangBean kh) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO KhachHang VALUES((SELECT MAX(Makh)+1 FROM dbo.KhachHang),?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
        /*    ps.setLong(1, kh.getMaKhachHang());*/
            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getDiaChi());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getTenDangNhap());
            ps.setString(6, kh.getMatKhau());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public KhachHangBean dangNhap(String tenDangNhap, String matKhau) {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM KhachHang WHERE tendn = ? AND matkhau = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHangBean kh = new KhachHangBean();
                kh.setMaKhachHang(rs.getLong("Makh"));
                kh.setHoTen(rs.getString("hoten"));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setSdt(rs.getString("SoDT"));
                kh.setEmail(rs.getString("email"));
                kh.setTenDangNhap(rs.getString("tendn"));
                kh.setMatKhau(rs.getString("matkhau"));
                connection.close();
                return kh;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public KhachHangBean getKhachHangByMaKhachHang(Long maKhacHang) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM  KhachHang WHERE Makh = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, maKhacHang);
            ResultSet rs = ps.executeQuery();
            KhachHangBean khachhang = new KhachHangBean();
            while(rs.next()) {
                khachhang.setHoTen(rs.getString("hoten"));
            }
            rs.close();
            connection.close();
            return khachhang;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
    public ArrayList<KhachHangBean> getListKhachHang(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM KhachHang";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<KhachHangBean> list = new ArrayList<>();
            while(rs.next()) {
                KhachHangBean khachhang = new KhachHangBean();
                khachhang.setMaKhachHang(rs.getLong("Makh"));
                khachhang.setHoTen(rs.getString("hoten"));
                khachhang.setDiaChi(rs.getString("diachi"));
                khachhang.setSdt(rs.getString("SoDT"));
                khachhang.setEmail(rs.getString("email"));
                khachhang.setTenDangNhap(rs.getString("tendn"));
                khachhang.setMatKhau(rs.getString("matkhau"));
                list.add(khachhang);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean xoaKhachHang(String maKhachHang) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM KhachHang WHERE Makh = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
