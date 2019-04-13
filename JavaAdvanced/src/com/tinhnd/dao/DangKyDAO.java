package com.tinhnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tinhnd.bean.DangKyBEAN;
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
public class DangKyDAO {
    /**
     * Hàm lấy danh sách khách hàng đăng ký
     * @param  
     * @return list
     * @throws
     */
    public ArrayList<DangKyBEAN> getListDangKy(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DangKy ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DangKyBEAN> list = new ArrayList<>();
            while(rs.next()) {
                DangKyBEAN dk = new DangKyBEAN();
                dk.setMaKH(rs.getString("MaKH"));
                dk.setTenKH(rs.getString("TenKH"));
                dk.setMaMay(rs.getString("MaMay"));
                dk.setViTri(rs.getString("ViTri"));
                dk.setTrangThai(rs.getString("TrangThai"));
                dk.setNgayBatDauSuDung(rs.getDate("NgayBatDauSuDung"));
                dk.setGioBatDauSuDung(rs.getString("GioBatDauSuDung"));
                dk.setThoiGianSuDung(rs.getString("ThoiGianSuDung"));
                dk.setMaDV(rs.getString("MaDV"));
                dk.setNgaySuDung(rs.getDate("NgaySuDung"));
                dk.setGioSuDung(rs.getString("GioSuDung"));
                dk.setSoLuong(rs.getInt("SoLuong"));
                dk.setTongTien(rs.getInt("TongTien"));
                
                
                list.add(dk);
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
     * Hàm lấy danh sách khách hàng đăng ký phân trang
     * @param  arr,start,end
     * @return list
     * @throws
     */
    public ArrayList<DangKyBEAN> getListDangKyByPage(ArrayList<DangKyBEAN> arr, int start, int end) {
        ArrayList<DangKyBEAN> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
}
