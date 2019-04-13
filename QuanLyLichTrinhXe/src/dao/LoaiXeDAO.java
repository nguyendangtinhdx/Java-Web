package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LoaiXeBEAN;

/**
* LoaiDAO
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
public class LoaiXeDAO {
    /**
     * Hàm lấy danh sách loại xe
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<LoaiXeBEAN> getListLoaiXe(){
        String sql = " SELECT * FROM LOAIXE ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<LoaiXeBEAN> list = new ArrayList<>();
            while(rs.next()) {
                LoaiXeBEAN m = new LoaiXeBEAN();
                m.setMaLoaiXe(rs.getString("MaLoaiXe"));
                m.setMoTaLoaiXe(rs.getString("MoTaLoaiXe"));
                m.setSoLuongChoNgoi(rs.getInt("SoLuongChoNgoi"));
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
