package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LoaiXeBEAN;
import bean.TuyenXeBEAN;

/**
* TuyenXeDAO
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
public class TuyenXeDAO {
    /**
     * Hàm lấy danh sách tuyến xe
     * @param  
     * @return list
     * @throws
     */
    
    public ArrayList<TuyenXeBEAN> getListTuyenXe(){
        String sql = " SELECT * FROM TUYENXE ";
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<TuyenXeBEAN> list = new ArrayList<>();
            while(rs.next()) {
                TuyenXeBEAN m = new TuyenXeBEAN();
                m.setMaTuyenXe(rs.getString("MaTuyen"));
                m.setTenTuyen(rs.getString("TenTuyen"));
                m.setDonGia(rs.getInt("DonGia"));
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
