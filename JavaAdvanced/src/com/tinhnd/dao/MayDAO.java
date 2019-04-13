package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tinhnd.bean.MayBEAN;
/**
 * MayDAO
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
public class MayDAO {
    /**
     * Hàm lấy danh sách máy
     * @param  
     * @return list
     * @throws
     */
    public ArrayList<MayBEAN> getListMay(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM MAY ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<MayBEAN> list = new ArrayList<>();
            while(rs.next()) {
                MayBEAN m = new MayBEAN();
                m.setMaMay(rs.getString("MaMay"));
                m.setViTri(rs.getString("ViTri"));
                m.setTrangThai(rs.getString("TrangThai"));
                list.add(m);
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
     * Hàm kiểm tra mã máy
     * @param  maMay
     * @return 
     * @throws
     */
    public boolean checkMaMay(String maMay) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT MaMay FROM MAY WHERE MaMay = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMay);
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
     * Hàm thêm mới máy
     * @param  m
     * @return 
     * @throws
     */
    public boolean themMay(MayBEAN m) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO MAY VALUES(?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getMaMay());
            ps.setString(2, m.getViTri());
            ps.setString(3, m.getTrangThai());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm sửa máy
     * @param  m
     * @return 
     * @throws
     */
    public boolean suaMay(MayBEAN m) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE MAY SET ViTri = ?, TrangThai = ?  WHERE MaMay = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, m.getViTri());
            ps.setString(2, m.getTrangThai());
            ps.setString(3, m.getMaMay());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm xóa máy
     * @param  maMay
     * @return 
     * @throws
     */
    public boolean xoaMay(String maMay) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM MAY WHERE MaMay = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maMay);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm tìm kiếm máy
     * @param  key
     * @return list
     * @throws
     */
    public ArrayList<MayBEAN> timKiemMay(String key){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM MAY WHERE MaMay LIKE ? OR ViTri LIKE ? OR TrangThai LIKE ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ps.setString(2, "%"+key+"%");
            ps.setString(3, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<MayBEAN> list = new ArrayList<>();
            while(rs.next()) {
                MayBEAN m = new MayBEAN();
                m.setMaMay(rs.getString("MaMay"));
                m.setViTri(rs.getString("ViTri"));
                m.setTrangThai(rs.getString("TrangThai"));
                list.add(m);
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
     * Hàm lấy danh sách máy phân trang
     * @param  arr,start,end
     * @return list
     * @throws
     */
    public ArrayList<MayBEAN> getListMayByPage(ArrayList<MayBEAN> arr, int start, int end) {
        ArrayList<MayBEAN> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
}
