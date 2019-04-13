package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tinhnd.bean.KhachHangBEAN;
/**
 * KhachHangDAO
 * 
 * Version 1.0
 * 
 * Date 31-1-2018
 * 
 * Copyright
 * 
 * Modification logs DATE AUTHOR DESCRIPTION
 * ------------------------------------------------ 31-1-2018 TỉnhND Create
 *
 */
public class KhachHangDAO {
    /**
     * Hàm lấy danh sách khách hàng
     * @param  
     * @return list
     * @throws
     */
    public ArrayList<KhachHangBEAN> getListKhachHang(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM KHACHHANG ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<KhachHangBEAN> list = new ArrayList<>();
            while(rs.next()) {
                KhachHangBEAN kh = new KhachHangBEAN();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setDiaChiEmail(rs.getString("DiaChiEmail"));
                list.add(kh);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Hàm kiểm tra mã khách hàng
     * @param  maKhachHang
     * @return 
     * @throws
     */
    public boolean checkMaKhachHang(String maKhachHang) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT MaKH FROM KHACHHANG WHERE MaKH = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rs.close();
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm thêm mới khách hàng
     * @param  kh
     * @return 
     * @throws
     */
    public boolean themKhachHang(KhachHangBEAN kh) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO KHACHHANG VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getSoDienThoai());
            ps.setString(5, kh.getDiaChiEmail());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm sửa khách hàng
     * @param  kh
     * @return 
     * @throws
     */
    public boolean suaKhachHang(KhachHangBEAN kh) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE KHACHHANG SET TenKH = ?, DiaChi = ?, SoDienThoai = ?, DiaChiEmail = ?  WHERE MaKH = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setString(3, kh.getSoDienThoai());
            ps.setString(4, kh.getDiaChiEmail());
            ps.setString(5, kh.getMaKH());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm xóa khách hàng
     * @param maKhachHang
     * @return 
     * @throws
     */
    public boolean xoaKhachHang(String maKhachHang) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM KHACHHANG WHERE MaKH = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm tìm kiếm khách hàng
     * @param  key
     * @return list
     * @throws
     */
    public ArrayList<KhachHangBEAN> timKiemKhachHang(String key){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM KHACHHANG WHERE MaKH LIKE ? OR TenKH LIKE ? OR DiaChi LIKE ? OR SoDienThoai LIKE ? OR DiaChiEmail LIKE ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ps.setString(2, "%"+key+"%");
            ps.setString(3, "%"+key+"%");
            ps.setString(4, "%"+key+"%");
            ps.setString(5, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<KhachHangBEAN> list = new ArrayList<>();
            while(rs.next()) {
                KhachHangBEAN kh = new KhachHangBEAN();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setDiaChiEmail(rs.getString("DiaChiEmail"));
                list.add(kh);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Hàm lấy danh sách khách hàng phân trang
     * @param  arr,start,end
     * @return list
     * @throws
     */
    public ArrayList<KhachHangBEAN> getListKhachHangByPage(ArrayList<KhachHangBEAN> arr, int start, int end) {
        ArrayList<KhachHangBEAN> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
}
