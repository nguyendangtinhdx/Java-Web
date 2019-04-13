package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Bean.QuanLySachBean;

public class QuanLySachDao {
    public ArrayList<QuanLySachBean> getListSach(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT s.*, l.tenloai FROM sach AS s INNER JOIN loai AS l ON l.maloai = s.maloai ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<QuanLySachBean> list = new ArrayList<>();
            while(rs.next()) {
                QuanLySachBean sach = new QuanLySachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getTimestamp("NgayNhap"));
                sach.setTenLoai(rs.getString("tenloai"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public ArrayList<QuanLySachBean> getListSachByPage(ArrayList<QuanLySachBean> arr, int start, int end) {
        ArrayList<QuanLySachBean> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
    public boolean themSach(QuanLySachBean s) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO sach VALUES(?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTacGia());
            ps.setLong(4, s.getSoLuong());
            ps.setLong(5, s.getGia());
            ps.setString(6, s.getSoTap());
            ps.setString(7, s.getAnh());
            ps.setString(8, s.getMaLoai());
            ps.setTimestamp(9, (Timestamp) s.getNgayNhap());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    public boolean suaSach(QuanLySachBean s) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE sach SET tensach = ?, tacgia = ?, soluong = ?, gia = ?, sotap = ?, anh = ?, maloai = ?, NgayNhap = ?  WHERE masach = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTacGia());
            ps.setLong(3, s.getSoLuong());
            ps.setLong(4, s.getGia());
            ps.setString(5, s.getSoTap());
            ps.setString(6, s.getAnh());
            ps.setString(7, s.getMaLoai());
            ps.setTimestamp(8, (Timestamp) s.getNgayNhap());
            ps.setString(9, s.getMaSach());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaSach(String maSach) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM sach WHERE masach = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maSach);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
