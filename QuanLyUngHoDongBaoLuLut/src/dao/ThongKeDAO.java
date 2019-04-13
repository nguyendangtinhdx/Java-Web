package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ThongKeBEAN;

public class ThongKeDAO {
    public ArrayList<ThongKeBEAN> getListThongKe(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM ThongKe ORDER BY TongSoTienMat DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ThongKeBEAN> list = new ArrayList<>();
            while(rs.next()) {
                ThongKeBEAN tk = new ThongKeBEAN();
                tk.setMaHoDan(rs.getString("MaHoDan"));
                tk.setHoTenChuHo(rs.getString("HoTenChuHo"));
                tk.setTo(rs.getLong("To"));
                tk.setKhoiHoacThon(rs.getString("KhoiHoacThon"));
                tk.setLaHoNgheo(rs.getString("LaHoNgheo"));
                tk.setTongSoTienMat(rs.getDouble("TongSoTienMat"));
                
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
