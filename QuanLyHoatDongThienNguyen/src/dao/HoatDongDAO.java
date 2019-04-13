package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConnect;
import bean.HoatDongBEAN;

public class HoatDongDAO {
    public ArrayList<HoatDongBEAN> getListHoatDong(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM HOATDONG ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoatDongBEAN> list = new ArrayList<>();
            while(rs.next()) {
                HoatDongBEAN hd = new HoatDongBEAN();
                hd.setMaHoatDong(rs.getString("MaHD"));
                hd.setTenHoatDong(rs.getString("TenHD"));
                hd.setMoTaHoatDong(rs.getString("MoTaHD"));
                hd.setNgayGioBatDau(rs.getTimestamp("NgayGioBD"));
                hd.setNgayGioKetThuc(rs.getTimestamp("NgayGioKT"));
                hd.setSoLuongToiThieu(rs.getLong("SLToiThieuYC"));
                hd.setSoLuongToiDa(rs.getLong("SLToiDaYC"));
                hd.setThoiHanDangKy(rs.getString("ThoiHanDK"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setMaThanhVien(rs.getString("MaTV"));
                hd.setLyDoHuyHoatDong(rs.getString("LyDoHuyHD"));
                list.add(hd);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean checkMa(String maHoatDong) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT MaHD FROM HOATDONG WHERE MaHD = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maHoatDong);
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
    
    public boolean themHoatDong(HoatDongBEAN hd) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO HOATDONG VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hd.getMaHoatDong());
            ps.setString(2, hd.getTenHoatDong());
            ps.setString(3, hd.getMoTaHoatDong());
            ps.setTimestamp(4, new java.sql.Timestamp( hd.getNgayGioBatDau().getTime()));
            ps.setTimestamp(5, new java.sql.Timestamp(hd.getNgayGioKetThuc().getTime()));
            ps.setLong(6, hd.getSoLuongToiThieu()); 
            ps.setLong(7, hd.getSoLuongToiDa());
            ps.setString(8, hd.getThoiHanDangKy());
            ps.setString(9, hd.getTrangThai());
            ps.setString(10, hd.getMaThanhVien());
            ps.setString(11, hd.getLyDoHuyHoatDong());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean suaHoatDong(HoatDongBEAN hd) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE HOATDONG SET TenHD = ?, MoTaHD = ?, NgayGioBD = ?, NgayGioKT = ?, SLToiThieuYC = ?, SLToiDaYC = ?, ThoiHanDK = ?, TrangThai = ?, MaTV = ?, LyDoHuyHD = ?  WHERE MaHD = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, hd.getTenHoatDong());
            ps.setString(2, hd.getMoTaHoatDong());
            ps.setTimestamp(3, new java.sql.Timestamp( hd.getNgayGioBatDau().getTime()));
            ps.setTimestamp(4, new java.sql.Timestamp(hd.getNgayGioKetThuc().getTime()));
            ps.setLong(5, hd.getSoLuongToiThieu()); 
            ps.setLong(6, hd.getSoLuongToiDa());
            ps.setString(7, hd.getThoiHanDangKy());
            ps.setString(8, hd.getTrangThai());
            ps.setString(9, hd.getMaThanhVien());
            ps.setString(10, hd.getLyDoHuyHoatDong());
            ps.setString(11, hd.getMaHoatDong());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaHoatDong(String maHD) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM HOATDONG WHERE MaHD = ? AND TrangThai != ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, "Đã kết thúc");
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
