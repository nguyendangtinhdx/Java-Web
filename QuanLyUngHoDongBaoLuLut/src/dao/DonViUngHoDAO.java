package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DonViUngHoBEAN;

public class DonViUngHoDAO {
    public ArrayList<DonViUngHoBEAN> getListDonViUngHo(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM DON_VI_UNG_HO ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DonViUngHoBEAN> list = new ArrayList<>();
            while(rs.next()) {
                DonViUngHoBEAN dvuh = new DonViUngHoBEAN();
                dvuh.setMaDonViUngHo(rs.getString("MaDVUH"));
                dvuh.setHoTenNguoiDaiDien(rs.getString("HoTenNguoiDaiDien"));
                dvuh.setDiaChiNguoiDaiDien(rs.getString("DiaChiNguoiDaiDien"));
                dvuh.setSoDienThoaiLienLac(rs.getString("SoDienThoaiLienLac"));
                dvuh.setSoCMNDNguoiDaiDien(rs.getString("SoCMNDNguoiDaiDien"));
                dvuh.setSoTaiKhoanNganHang(rs.getString("SoTaiKhoanNganHang"));
                dvuh.setTenNganHang(rs.getString("TenNganHang"));
                dvuh.setChiNhanhNganHang(rs.getString("ChiNhanhNganHang"));
                dvuh.setTenChuTaiKhoanNganHang(rs.getString("TenChuTKNganHang"));
                list.add(dvuh);
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
