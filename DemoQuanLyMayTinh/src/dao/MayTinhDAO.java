package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MayTinhBEAN;


public class MayTinhDAO {
    /**
     * MayTinhDAO
     * 
     * Version 1.0
     * 
     * Date 7-3-2018
     * 
     * Copyright
     * 
     * Modification logs DATE AUTHOR DESCRIPTION
     * ------------------------------------------------ 7-3-2018 TỉnhND Create
     *
     */
    /**
     * Hàm lấy danh sách máy 
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<MayTinhBEAN> getListMay(){
        String sql = " SELECT * FROM MAYTINH ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<MayTinhBEAN> list = new ArrayList<>();
            while(rs.next()) {
                MayTinhBEAN m = new MayTinhBEAN();
                m.setMa(rs.getString("Ma"));
                m.setTen(rs.getString("Ten"));
                m.setGia(rs.getInt("Gia"));
                m.setSoLuong(rs.getInt("SoLuong"));
                m.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                m.setMaHang(rs.getString("MaHang"));
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
    public boolean checkMa(String ma) {
        String sql = " SELECT Ma FROM MAYTINH WHERE Ma = ? ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
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
    public boolean themMay(MayTinhBEAN m) {
        String sql = " INSERT INTO MAYTINH VALUES(?,?,?,?,?,?) ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getMa());
            ps.setString(2, m.getTen());
            ps.setInt(3, m.getGia());
            ps.setInt(4, m.getSoLuong());
            ps.setDate(5, new java.sql.Date(m.getNgaySanXuat().getTime()));
            ps.setString(6, m.getMaHang());
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
    public boolean suaMay(MayTinhBEAN m) {
        String sql = " UPDATE MAYTINH SET Ten = ?, Gia = ?, SoLuong = ?, NgaySanXuat = ?, MaHang = ?  WHERE Ma = ? ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, m.getTen());
            ps.setInt(2, m.getGia());
            ps.setInt(3, m.getSoLuong());
            ps.setDate(4, new java.sql.Date(m.getNgaySanXuat().getTime()));
            ps.setString(5, m.getMaHang());
            ps.setString(6, m.getMa());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Hàm xóa máy 
     * @param  ma
     * @return 
     * @throws
     */
    public boolean xoaMay(String ma) {
        String sql = " DELETE FROM MAYTINH WHERE Ma = ? ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
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
    public ArrayList<MayTinhBEAN> timKiemMay(String key){
        String sql = " SELECT * FROM MAYTINH WHERE Ten LIKE ? OR Gia LIKE ? OR SoLuong LIKE ? ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ps.setString(2, "%"+key+"%");
            ps.setString(3, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<MayTinhBEAN> list = new ArrayList<>();
            while(rs.next()) {
                MayTinhBEAN m = new MayTinhBEAN();
                m.setMa(rs.getString("Ma"));
                m.setTen(rs.getString("Ten"));
                m.setGia(rs.getInt("Gia"));
                m.setSoLuong(rs.getInt("SoLuong"));
                m.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                m.setMaHang(rs.getString("MaHang"));
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
}
