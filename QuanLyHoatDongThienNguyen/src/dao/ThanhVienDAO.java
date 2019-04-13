package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ThanhVienBEAN;

public class ThanhVienDAO {
    public ArrayList<ThanhVienBEAN> getListThanhVien(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT MaTV,HoTen FROM THANHVIEN ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ThanhVienBEAN> list = new ArrayList<>();
            while(rs.next()) {
                ThanhVienBEAN tv = new ThanhVienBEAN();
                tv.setMaThanhVien(rs.getString("MaTV"));
                tv.setHoTen(rs.getString("HoTen"));
                list.add(tv);
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
