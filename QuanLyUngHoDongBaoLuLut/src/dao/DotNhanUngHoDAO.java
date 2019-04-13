package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DotNhanUngHoBEAN;

public class DotNhanUngHoDAO {
    public ArrayList<DotNhanUngHoBEAN> getListDotNhanUngHo(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT dnuh.*,ctdnuh.HinhThucNhanUngHo,ctdnuh.SoLuongNhanUngHo \n" + 
                "FROM DOT_NHAN_UNG_HO AS dnuh INNER JOIN CHI_TIET_DOT_NHAN_UNG_HO AS ctdnuh \n" + 
                "ON ctdnuh.MaDotNhanUngHo = dnuh.MaDotNhanUngHo ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DotNhanUngHoBEAN> list = new ArrayList<>();
            while(rs.next()) {
                DotNhanUngHoBEAN dnuh = new DotNhanUngHoBEAN();
                dnuh.setMaDotNhanUngHo(rs.getString("MaDotNhanUngHo"));
                dnuh.setMaHoDan(rs.getString("MaHoDan"));
                dnuh.setNgayNhanUngHo(rs.getDate("NgayNhanUngHo"));
                dnuh.setHinhThucNhanUngHo(rs.getString("HinhThucNhanUngHo"));
                dnuh.setSoLuongNhanUngHo(rs.getLong("SoLuongNhanUngHo"));
                
                list.add(dnuh);
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
