package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DotUngHoBEAN;

public class DotUngHoDAO {
    public ArrayList<DotUngHoBEAN> getListDotUngHo(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DOT_UNG_HO ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DotUngHoBEAN> list = new ArrayList<>();
            while(rs.next()) {
                DotUngHoBEAN duh = new DotUngHoBEAN();
                duh.setMaDotUngHo(rs.getString("MaDotUngHo"));
                duh.setMaDonViUngHo(rs.getString("MaDVUH"));
                duh.setNgayUngHo(rs.getDate("NgayUngHo"));
                list.add(duh);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkMa(String maDotUngHo) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT MaDotUngHo FROM DOT_UNG_HO WHERE MaDotUngHo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maDotUngHo);
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
    
    public boolean themDotUngHo(DotUngHoBEAN duh) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO DOT_UNG_HO VALUES(?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, duh.getMaDotUngHo());
            ps.setString(2, duh.getMaDonViUngHo());
            ps.setDate(3, new java.sql.Date(duh.getNgayUngHo().getTime()));

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaDotUngHo(DotUngHoBEAN duh) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE DOT_UNG_HO SET MaDVUH = ?, NgayUngHo = ?  WHERE MaDotUngHo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, duh.getMaDonViUngHo());
            ps.setDate(2, new java.sql.Date(duh.getNgayUngHo().getTime()));
            ps.setString(3, duh.getMaDotUngHo());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaHoatDong(String maDotUngHo) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM DOT_UNG_HO WHERE MaDotUngHo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maDotUngHo);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
