package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.HoKhauBEAN;

public class HoKhauDAO {
    public ArrayList<HoKhauBEAN> getListHoKhau(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT hk.*,cd.Ten FROM HOKHAU AS hk INNER JOIN CONGDAN AS cd ON hk.ChuHoID = cd.CmndID ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoKhauBEAN> list = new ArrayList<>();
            while(rs.next()) {
                HoKhauBEAN cd = new HoKhauBEAN();
                cd.setHoKhauID(rs.getString("HoKhauID"));
                cd.setTinh_TP(rs.getString("Tinh_TP"));
                cd.setQuan_Huyen(rs.getString("Quan_Huyen"));
                cd.setPhuong_Xa(rs.getString("Phuong_Xa"));
                cd.setTo_Thon(rs.getString("To_Thon"));
                cd.setChuHoID(rs.getString("ChuHoID"));
                cd.setTen(rs.getString("Ten"));

                list.add(cd);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean suaHoKhau(HoKhauBEAN hd) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE HOKHAU SET Tinh_TP = ?, Quan_Huyen = ?, Phuong_Xa = ?, To_Thon = ?, ChuHoID = ? WHERE HoKhauID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, hd.getTinh_TP());
            ps.setString(2, hd.getQuan_Huyen());
            ps.setString(3, hd.getPhuong_Xa()); 
            ps.setString(4, hd.getTo_Thon());
            ps.setString(5, hd.getChuHoID());
            ps.setString(6, hd.getHoKhauID());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
