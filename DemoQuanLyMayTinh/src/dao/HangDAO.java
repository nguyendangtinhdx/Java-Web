package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.HangBEAN;
import bean.MayTinhBEAN;

public class HangDAO {
    /**
     * HangDAO
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
    
    /**
     * Hàm lấy danh sách hãng
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<HangBEAN> getListHang(){
        String sql = " SELECT * FROM HANG ";
        try {
            Connection connection = DBconnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<HangBEAN> list = new ArrayList<>();
            while(rs.next()) {
                HangBEAN m = new HangBEAN();
                m.setMaHang(rs.getString("MaHang"));
                m.setTenHang(rs.getString("TenHang"));
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
