package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.HangBean;

public class HangDao {
    public ArrayList<HangBean> getListHang(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM Hang ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<HangBean> list = new ArrayList<>();
            while(rs.next()) {
                HangBean hang = new HangBean();
                hang.setMaHang(rs.getString("MaHang"));
                hang.setTenHang(rs.getString("TenHang"));
                list.add(hang);
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
