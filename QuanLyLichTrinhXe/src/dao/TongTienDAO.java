package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.TongTienBEAN;
import bean.XeBEAN;

/**
 * TongTienDAO
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
public class TongTienDAO {
    /**
     * Hàm lấy danh sách  xe
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<TongTienBEAN> getListTongTien(){
        String sql = " SELECT NHAXE.MaNhaXe, TenNhaXe, (DonGia * SoLuongHanhKhach) AS TongTien FROM dbo.LICHTRINHXE INNER JOIN dbo.TUYENXE ON TUYENXE.MaTuyen = LICHTRINHXE.MaTuyen\n" + 
                "INNER JOIN dbo.XE ON XE.MaXe = LICHTRINHXE.MaXe\n" + 
                "INNER JOIN dbo.NHAXE ON NHAXE.MaNhaXe = XE.MaNhaXe ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<TongTienBEAN> list = new ArrayList<>();
            while(rs.next()) {
                TongTienBEAN m = new TongTienBEAN();
                m.setMaNhaXe(rs.getString("MaNhaXe"));
                m.setTenNhaXe(rs.getString("TenNhaXe"));
                m.setTongTien(rs.getInt("TongTien"));
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
}
