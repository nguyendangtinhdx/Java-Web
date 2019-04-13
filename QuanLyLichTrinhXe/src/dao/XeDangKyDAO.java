package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LichTrinhXeBEAN;
import bean.XeBEAN;
import bean.XeDangKyBEAN;
/**
 * XeDangKyDAO
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
public class XeDangKyDAO {
    /**
     * Hàm lấy danh sách xe đăng ký
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<XeDangKyBEAN> getListXeDangKy(){
        String sql = " SELECT * FROM XEDANGKY ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<XeDangKyBEAN> list = new ArrayList<>();
            while(rs.next()) {
                XeDangKyBEAN m = new XeDangKyBEAN();
                m.setMaXe(rs.getString("MaXe"));
                m.setBienSo(rs.getString("BienSo"));
                m.setTenTaiXe(rs.getString("TenTaiXe"));
                m.setTenNhaXe(rs.getString("TenNhaXe"));
                m.setMaTuyen(rs.getString("MaTuyen"));
                m.setTenTuyen(rs.getString("TenTuyen"));
                m.setNgayXuatBen(rs.getDate("NgayXuatBen"));
                m.setGioXuatBen(rs.getString("GioXuatBen"));
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
     * Hàm tìm kiếm xe đăng ký 
     * @param  key
     * @return list
     * @throws
     */
    
    public ArrayList<XeDangKyBEAN> getListXeDangKyByKey(String key){
        String sql = " SELECT * FROM XEDANGKY WHERE TenNhaXe LIKE ? ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<XeDangKyBEAN> list = new ArrayList<>();
            while(rs.next()) {
                XeDangKyBEAN m = new XeDangKyBEAN();
                m.setMaXe(rs.getString("MaXe"));
                m.setBienSo(rs.getString("BienSo"));
                m.setTenTaiXe(rs.getString("TenTaiXe"));
                m.setTenNhaXe(rs.getString("TenNhaXe"));
                m.setMaTuyen(rs.getString("MaTuyen"));
                m.setTenTuyen(rs.getString("TenTuyen"));
                m.setNgayXuatBen(rs.getDate("NgayXuatBen"));
                m.setGioXuatBen(rs.getString("GioXuatBen"));
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
     * Hàm thêm mới lịch trình xe xe
     * @param  m
     * @return 
     * @throws
     */
    public boolean themLichTrinhXe(LichTrinhXeBEAN m) {
        String sql = " INSERT INTO LICHTRINHXE VALUES(?,?,?,?,?,?) ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, m.getMaXe());
            ps.setString(2, m.getTenTaiXe());
            ps.setString(3, m.getMaTuyen());
            ps.setDate(4, new java.sql.Date(m.getNgayXuatBen().getTime()));
            ps.setString(5, m.getGioXuatBen());
            ps.setInt(6, m.getSoLuongHanhKhach());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
