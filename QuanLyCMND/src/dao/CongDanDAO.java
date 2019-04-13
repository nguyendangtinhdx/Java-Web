package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CongDanBEAN;

public class CongDanDAO {
    public ArrayList<CongDanBEAN> getListCongDan(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM CONGDAN ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<CongDanBEAN> list = new ArrayList<>();
            while(rs.next()) {
                CongDanBEAN cd = new CongDanBEAN();
                cd.setCmndID(rs.getString("CmndID"));
                cd.setTen(rs.getString("Ten"));
                cd.setHo(rs.getString("Ho"));
                cd.setNgaySinh(rs.getDate("NgaySinh"));
                cd.setGioiTinh(rs.getLong("GioiTinh"));
                cd.setNoiSinh(rs.getString("NoiSinh"));
                cd.setTinhTrangHonNhan(rs.getString("TTHonNhan"));
                cd.setNgheNghiep(rs.getString("NgheNghiep"));

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
    public boolean checkMa(String cmndID) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT CmndID FROM CONGDAN WHERE CmndID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cmndID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rs.close();
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean themCongDan(CongDanBEAN cd) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO CONGDAN VALUES(?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd.getCmndID());
            ps.setString(2, cd.getTen());
            ps.setString(3, cd.getHo());
            ps.setDate(4, new java.sql.Date(cd.getNgaySinh().getTime()));
            ps.setLong(5, cd.getGioiTinh()); 
            ps.setString(6, cd.getNoiSinh());
            ps.setString(7, cd.getTinhTrangHonNhan());
            ps.setString(8, cd.getNgheNghiep());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
