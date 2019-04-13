package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.LichSuLuuTruBEAN;;

public class LichSuLuuTruDAO {
    public ArrayList<LichSuLuuTruBEAN> getListLichSuLuuTru(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM LichSuLuuTru ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<LichSuLuuTruBEAN> list = new ArrayList<>();
            while(rs.next()) {
                LichSuLuuTruBEAN ls = new LichSuLuuTruBEAN();
                ls.setCmndID(rs.getString("CmndID"));
                ls.setHoKhauID(rs.getString("HoKhauID"));
                ls.setLoaiLuuTruID(rs.getString("LoaiLuuTruID"));
                ls.setThoiGianBatDauLT(rs.getDate("ThoiGianBatDauLT"));
                ls.setThoiGianKetThucLT(rs.getDate("ThoiGianKetThucLT"));
                ls.setQuanHeVoiChuHo(rs.getString("QuanHeVoiChuHo"));

                list.add(ls);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean xoaLichSu(Date n) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM LichSuLuuTru WHERE ThoiGianBatDauLT = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) n );
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
