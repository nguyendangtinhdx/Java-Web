package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.XeBEAN;

/**
 * XeDAO
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
public class XeDAO {
    
    /**
     * Hàm lấy danh sách  xe
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<XeBEAN> getListXe(){
        String sql = " SELECT * FROM XE ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<XeBEAN> list = new ArrayList<>();
            while(rs.next()) {
                XeBEAN m = new XeBEAN();
                m.setMaXe(rs.getString("MaXe"));
                m.setHangSanXuat(rs.getString("HangSanXuat"));
                m.setMaLoaiXe(rs.getString("MaLoaiXe"));
                m.setBienSo(rs.getString("BienSo"));
                m.setHanKiemDinh(rs.getDate("HanKiemDinh"));
                m.setMaNhaXe(rs.getString("MaNhaXe"));
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
     * Hàm thêm mới xe
     * @param  m
     * @return 
     * @throws
     */
    public boolean themXe(XeBEAN m) {
        String sql = " INSERT INTO XE VALUES(?,?,?,?,?,?) ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getMaXe());
            ps.setString(2, m.getHangSanXuat());
            ps.setString(3, m.getMaLoaiXe());
            ps.setString(4, m.getBienSo());
            ps.setDate(5, new java.sql.Date(m.getHanKiemDinh().getTime()));
            ps.setString(6, m.getMaNhaXe());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
