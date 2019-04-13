package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tinhnd.bean.SuDungDichVuBEAN;
/**
 * SuDungDichVuDAO
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
public class SuDungDichVuDAO {
    /**
     * Hàm lấy danh sách sử dụng dịch vụ
     * @param  
     * @return list
     * @throws
     */
    public ArrayList<SuDungDichVuBEAN> getListSuDungDichVu(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM SuDungDichVu ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<SuDungDichVuBEAN> list = new ArrayList<>();
            while(rs.next()) {
                SuDungDichVuBEAN dv = new SuDungDichVuBEAN();
                dv.setMaKH(rs.getString("MaKH"));
                dv.setMaDV(rs.getString("MaDV"));
                dv.setNgaySuDung(rs.getDate("NgaySuDung"));
                dv.setGioSuDung(rs.getString("GioSuDung"));
                dv.setSoLuong(rs.getInt("SoLuong"));
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
     * Hàm thêm sử dụng dịch vụ
     * @param  dv
     * @return 
     * @throws
     */
    public boolean themSuDungDichVu(SuDungDichVuBEAN dv) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO SUDUNGDICHVU VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dv.getMaKH());
            ps.setString(2, dv.getMaDV());
            ps.setDate(3, new java.sql.Date(dv.getNgaySuDung().getTime()));
            ps.setString(4, dv.getGioSuDung());
            ps.setInt(5, dv.getSoLuong());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
