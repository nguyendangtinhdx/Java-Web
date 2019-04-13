package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.LoaiBean;

public class LoaiDao {
    // lấy danh sách loại
    public ArrayList<LoaiBean> getListLoai(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM loai ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<LoaiBean> list = new ArrayList<>();
            while(rs.next()) {
                LoaiBean loai = new LoaiBean();
                loai.setMaLoai(rs.getString("maloai"));
                loai.setTenLoai(rs.getString("tenloai"));
                list.add(loai);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<LoaiBean> getListLoaiTuNhien(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM dbo.loai WHERE maloai = 'Dia ly' OR maloai = 'Hoa hoc' OR maloai = 'Khoa hoc'\n" + 
                "OR maloai = 'Kinh te' OR maloai = 'On thi CD-DH' OR maloai = 'Tin' OR maloai = 'Toan' \n" + 
                "OR maloai = 'Vat ly' OR maloai = 'Y hoc' ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<LoaiBean> list = new ArrayList<>();
            while(rs.next()) {
                LoaiBean loai = new LoaiBean();
                loai.setMaLoai(rs.getString("maloai"));
                loai.setTenLoai(rs.getString("tenloai"));
                list.add(loai);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<LoaiBean> getListLoaiXaHoi(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM dbo.loai WHERE maloai = 'Bi quyet cuoc song' OR maloai = 'Chinh tri' \n" + 
                "OR maloai = 'Lich su' OR maloai = 'Ngoai ngu'OR maloai = 'Tam ly' OR maloai = 'Van' ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<LoaiBean> list = new ArrayList<>();
            while(rs.next()) {
                LoaiBean loai = new LoaiBean();
                loai.setMaLoai(rs.getString("maloai"));
                loai.setTenLoai(rs.getString("tenloai"));
                list.add(loai);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    // thêm loại sách
    public boolean themLoai(LoaiBean l) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT INTO loai VALUES(?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, l.getMaLoai());
            ps.setString(2, l.getTenLoai());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // sửa loại
    
    public boolean suaLoai(LoaiBean l) {
        Connection connection = DBConnect.getConnection();
        String sql = " UPDATE loai SET tenloai = ?  WHERE maloai = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, l.getTenLoai());
            ps.setString(2, l.getMaLoai());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // xóa loại
    
    public boolean xoaLoai(String maLoai) {
        Connection connection = DBConnect.getConnection();
        String sql = " DELETE FROM loai WHERE maloai = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
