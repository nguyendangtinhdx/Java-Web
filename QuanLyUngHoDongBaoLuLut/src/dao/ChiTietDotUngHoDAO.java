package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ChiTietDotUngHoBEAN;

public class ChiTietDotUngHoDAO {
    public ArrayList<ChiTietDotUngHoBEAN> getListChiTietDotUngHo(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM CHI_TIET_DOT_UNG_HO ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ChiTietDotUngHoBEAN> list = new ArrayList<>();
            while(rs.next()) {
                ChiTietDotUngHoBEAN ctduh = new ChiTietDotUngHoBEAN();
                ctduh.setMaDotUngHo(rs.getString("MaDotUngHo"));
                ctduh.setHinhThucUngHo(rs.getString("HinhThucUngHo"));
                ctduh.setSoLuongUngHo(rs.getLong("SoLuongUngHo"));
                ctduh.setDonViTinh(rs.getString("DonViTinh"));
                list.add(ctduh);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean checkMa(String hinhThucUngHo) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT HinhThucUngHo FROM CHI_TIET_DOT_UNG_HO WHERE HinhThucUngHo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hinhThucUngHo);
            ResultSet rs = ps.executeQuery();
            boolean kq = rs.next();

                rs.close();
                connection.close();
                return kq;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean themChiTietDotUngHo(ChiTietDotUngHoBEAN ctduh) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO CHI_TIET_DOT_UNG_HO VALUES(?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ctduh.getMaDotUngHo());
            ps.setString(2, ctduh.getHinhThucUngHo());
            ps.setLong(3, ctduh.getSoLuongUngHo());
            ps.setString(4, ctduh.getDonViTinh());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaChiTietDotUngHo(ChiTietDotUngHoBEAN ctduh) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE CHI_TIET_DOT_UNG_HO SET MaDotUngHo = ?, SoLuongUngHo = ?, DonViTinh = ?  WHERE HinhThucUngHo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ctduh.getMaDotUngHo());
            ps.setLong(2, ctduh.getSoLuongUngHo());
            ps.setString(3, ctduh.getDonViTinh());
            ps.setString(4, ctduh.getHinhThucUngHo());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaChiTietHoatDong(String hinhThucUngHo) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM CHI_TIET_DOT_UNG_HO WHERE HinhThucUngHo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hinhThucUngHo);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
