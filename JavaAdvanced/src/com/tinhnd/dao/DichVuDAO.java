package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tinhnd.bean.DichVuBEAN;
/**
 * DangKyDAO
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
public class DichVuDAO {
    /**
     * Hàm lấy danh sách dịch vụ
     * @param  
     * @return list
     * @throws
     */
    public ArrayList<DichVuBEAN> getListDichVu(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DichVu ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DichVuBEAN> list = new ArrayList<>();
            while(rs.next()) {
                DichVuBEAN dv = new DichVuBEAN();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setDonViTinh(rs.getString("DonViTinh"));
                dv.setDonGia(rs.getInt("DonGia"));
                list.add(dv);
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
     * Hàm kiểm tra mã dịch vụ
     * @param  maDV
     * @return 
     * @throws
     */
    public boolean checkMaDV(String maDV) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT MaDV FROM DICHVU WHERE MaDV = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maDV);
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
     * Hàm thêm mới dịch vụ
     * @param  dv
     * @return 
     * @throws
     */
    public boolean themDichVu(DichVuBEAN dv) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO DICHVU VALUES(?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dv.getMaDV());
            ps.setString(2, dv.getTenDV());
            ps.setString(3, dv.getDonViTinh());
            ps.setInt(4, dv.getDonGia());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm sửa dịch vụ
     * @param  dv
     * @return 
     * @throws
     */
    public boolean suaDichVu(DichVuBEAN dv) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE DICHVU SET TenDV = ?, DonViTinh = ?, DonGia = ?  WHERE MaDV = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, dv.getTenDV());
            ps.setString(2, dv.getDonViTinh());
            ps.setInt(3, dv.getDonGia());
            ps.setString(4, dv.getMaDV());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm xóa dịch vụ
     * @param  dv
     * @return 
     * @throws
     */
    public boolean xoaDichVu(String maDV) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM DICHVU WHERE MaDV = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maDV);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm tìm kiếm dịch vụ
     * @param  key
     * @return list
     * @throws
     */
    public ArrayList<DichVuBEAN> timKiemDichVu(String key){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DICHVU WHERE MaDV LIKE ? OR TenDV LIKE ? OR DonViTinh LIKE ? OR DonViTinh = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ps.setString(2, "%"+key+"%");
            ps.setString(3, "%"+key+"%");
            ps.setString(4, key);
            ResultSet rs = ps.executeQuery();
            ArrayList<DichVuBEAN> list = new ArrayList<>();
            while(rs.next()) {
                DichVuBEAN dv = new DichVuBEAN();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setDonViTinh(rs.getString("DonViTinh"));
                dv.setDonGia(rs.getInt("DonGia"));
                list.add(dv);
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
     * Hàm lấy danh sách dịch vụ phân trang
     * @param  arr,start,end
     * @return list
     * @throws
     */
    public ArrayList<DichVuBEAN> getListDichVuByPage(ArrayList<DichVuBEAN> arr, int start, int end) {
        ArrayList<DichVuBEAN> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
}
