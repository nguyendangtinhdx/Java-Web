package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tinhnd.bean.SuDungMayBEAN;
/**
 * SuDungMayDAO
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
public class SuDungMayDAO {
    /**
     * Hàm thêm sử dụng máy
     * @param  m
     * @return 
     * @throws
     */
    public boolean themSuDungMay(SuDungMayBEAN m) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO SUDUNGMAY VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getMaKH());
            ps.setString(2, m.getMaMay());
            ps.setDate(3, new java.sql.Date(m.getNgayBatDauSuDung().getTime()));
            ps.setString(4, m.getGioBatDauSuDung());
            ps.setString(5, m.getThoiGianSuDung());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
