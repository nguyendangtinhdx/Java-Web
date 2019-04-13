package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ThongKeHoaDonBean;

public class ThongKeHoaDonDao {
    public ArrayList<ThongKeHoaDonBean> getListThongKeHoaDon(String hoten){
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM ThongKeHoaDon WHERE tendn = '"+ hoten +"' ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ThongKeHoaDonBean> list = new ArrayList<>();
            while(rs.next()) {
                ThongKeHoaDonBean tk = new ThongKeHoaDonBean();
                tk.setHoTen(rs.getString("HoTen"));
                tk.setTenSach(rs.getString("TenSach"));
                tk.setSoLuongMua(rs.getLong("SoLuongMua"));
                tk.setGia(rs.getLong("Gia"));
                tk.setThanhTien(rs.getLong("ThanhTien"));
                tk.setTinhTrang(rs.getBoolean("DaMua"));
                list.add(tk);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
