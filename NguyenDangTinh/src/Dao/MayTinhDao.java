package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.MayTinhBean;

public class MayTinhDao {
    public ArrayList<MayTinhBean> getListMayTinhByHang(String maHang){
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM MayTinh WHERE MaHang = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maHang);
            ResultSet rs = ps.executeQuery();
            ArrayList<MayTinhBean> list = new ArrayList<>();
            while(rs.next()) {
                MayTinhBean mt = new MayTinhBean();
                mt.setMa(rs.getString("Ma"));
                mt.setTen(rs.getString("Ten"));
                mt.setGia(rs.getLong("Gia"));
                mt.setSoLuong(rs.getLong("SoLuong"));
                mt.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                mt.setMaHang(rs.getString("MaHang"));
                
                list.add(mt);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<MayTinhBean> getListMayTinhByKey(String key){
        Connection connection = DBConnect.getConnection();
        String sql = "  SELECT mt.* FROM MayTinh AS mt INNER JOIN Hang h ON h.MaHang = mt.MaHang \n" + 
                "  WHERE mt.Ten = ? OR h.TenHang = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, key);
            ps.setString(2, key);
            ResultSet rs = ps.executeQuery();
            ArrayList<MayTinhBean> list = new ArrayList<>();
            while(rs.next()) {
                MayTinhBean mt = new MayTinhBean();
                mt.setMa(rs.getString("Ma"));
                mt.setTen(rs.getString("Ten"));
                mt.setGia(rs.getLong("Gia"));
                mt.setSoLuong(rs.getLong("SoLuong"));
                mt.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                mt.setMaHang(rs.getString("MaHang"));
                list.add(mt);
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
