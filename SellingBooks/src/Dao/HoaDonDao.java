package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Bean.HoaDonBean;

public class HoaDonDao {
    public int themHoaDon(HoaDonBean hoaDon) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO hoadon VALUES((SELECT MAX(MaHoaDon)+1 FROM hoadon),?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, hoaDon.getMaKhachHang());
            ps.setTimestamp(2, (Timestamp) hoaDon.getNgayMua());
            ps.setBoolean(3, hoaDon.isDaMua());
            return  ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<HoaDonBean> getListHoaDon(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT hd.*, kh.hoten FROM hoadon AS hd INNER JOIN KhachHang AS kh ON kh.Makh = hd.makh  ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoaDonBean> list = new ArrayList<>();
            while(rs.next()) {
                HoaDonBean hoadon = new HoaDonBean();
                hoadon.setMaHoaDon(rs.getLong("MaHoaDon"));
                hoadon.setMaKhachHang(rs.getLong("makh"));
                hoadon.setNgayMua(rs.getTimestamp("NgayMua"));
                hoadon.setDaMua(rs.getBoolean("damua"));
                hoadon.setHoTen(rs.getString("hoten"));
                list.add(hoadon);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean xoaHoaDon(String maHoaDon) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM hoadon WHERE MaHoaDon = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maHoaDon);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xacNhanHoaDon(String maHoaDon) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE hoadon SET damua = ? WHERE MaHoaDon = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, maHoaDon);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
