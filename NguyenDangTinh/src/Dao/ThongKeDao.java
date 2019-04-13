package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ThongKeBean;

public class ThongKeDao {
    public ArrayList<ThongKeBean> getListThongKe(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM ThongKe ORDER BY TongSoLuong DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ThongKeBean> list = new ArrayList<>();
            while(rs.next()) {
                ThongKeBean tk = new ThongKeBean();
                tk.setTenHang(rs.getString("TenHang"));
                tk.setTongSoLuong(rs.getLong("TongSoLuong"));
                tk.setTrungBinhCong(rs.getLong("TrungBinhCong"));
                list.add(tk);
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
