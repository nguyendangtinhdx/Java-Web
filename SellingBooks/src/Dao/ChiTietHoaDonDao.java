package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ChiTietHoaDonBean;

public class ChiTietHoaDonDao {
    public int themChiTietHoaDon(ChiTietHoaDonBean chiTietHoaDon) {
        Connection connection = DBConnect.getConnection();
        String sql  = " INSERT INTO ChiTietHoaDon VALUES((SELECT MAX(MaChiTietHD)+1 FROM ChiTietHoaDon),?,?,(SELECT MAX(MaHoaDon) FROM hoadon),?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, chiTietHoaDon.getMaSach());
            ps.setLong(2, chiTietHoaDon.getSoLuongMua());
            ps.setFloat(3, chiTietHoaDon.getGia());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

   public ArrayList<ChiTietHoaDonBean> getListChiTietHoaDon(){
       Connection connection = DBConnect.getConnection();
       String sql = " SELECT cthd.*, s.tensach FROM ChiTietHoaDon AS cthd INNER JOIN sach AS s ON s.masach = cthd.MaSach  ";
       try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           ArrayList<ChiTietHoaDonBean> list = new ArrayList<>();
           while(rs.next()) {
               ChiTietHoaDonBean cthd = new ChiTietHoaDonBean();
               cthd.setMaChiTietHoaDon(rs.getLong("MaChiTietHD"));
               cthd.setMaSach(rs.getString("MaSach"));
               cthd.setSoLuongMua(rs.getLong("SoLuongMua"));
               cthd.setMaHoaDon(rs.getLong("MaHoaDon"));
               cthd.setGia(rs.getFloat("Gia"));
               cthd.setTenSach(rs.getString("TenSach"));
               list.add(cthd);
           }
           rs.close();
           connection.close();
           return list;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
   }
   
   public boolean xoaChiTietHoaDon(String maChiTietHoaDon) {
       Connection connection = DBConnect.getConnection();
       String sql = " DELETE FROM ChiTietHoaDon WHERE maChiTietHD= ? ";
       try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, maChiTietHoaDon);
           return ps.executeUpdate() == 1;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }
   
   public boolean suaChiTietHoaDon(Long maCTHD,Long soLuong) {
       Connection connection = DBConnect.getConnection();
       String sql = " UPDATE ChiTietHoaDon SET SoLuongMua = ? WHERE MaChiTietHD = ? ";
       try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setLong(1, soLuong);
           ps.setLong(2, maCTHD);
           
           return ps.executeUpdate() == 1;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }
   
}
