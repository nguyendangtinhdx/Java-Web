package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.NhaXeBEAN;

/**
* NhaDAO
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
public class NhaXeDAO {
    /**
     * Hàm lấy danh sách nhà xe
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<NhaXeBEAN> getListNhaXe(){
        String sql = " SELECT * FROM NHAXE ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<NhaXeBEAN> list = new ArrayList<>();
            while(rs.next()) {
                NhaXeBEAN m = new NhaXeBEAN();
                m.setMaNhaXe(rs.getString("MaNhaXe"));
                m.setTenNhaXe(rs.getString("TenNhaXe"));
                m.setNamThanhLap(rs.getInt("NamThanhLap"));
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
