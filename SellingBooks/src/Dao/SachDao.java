package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.SachBean;

public class SachDao {
    
    public ArrayList<SachBean> getListSach(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT s.*, l.tenloai FROM sach AS s INNER JOIN loai AS l ON l.maloai = s.maloai ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                sach.setTenLoai(rs.getString("tenloai"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    // lấy danh sách sách bởi mã loại
    public ArrayList<SachBean> getListSachByLoai(String maLoai){
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM sach WHERE maloai = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachByLoaiMoiNhat(String maLoai){
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT TOP(3) * FROM sach WHERE maloai = ? ORDER BY NgayNhap DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public ArrayList<SachBean> getListSachKhoaHoc(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TOP(4) * FROM sach WHERE maloai = 'Khoa hoc' ORDER BY NgayNhap DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachToanHoc(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TOP(4) * FROM sach WHERE maloai = 'Toan' ORDER BY NgayNhap DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    // hiển thị chi tiết sách
    public SachBean getSach(String maSach) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM sach WHERE masach = ? ";
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maSach);
            ResultSet rs = ps.executeQuery();
            SachBean sach = new SachBean();
            while(rs.next()) {
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
            }
            rs.close();
            connection.close();
            return sach;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachMoiNhat(String maLoai,String maSach) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TOP(3) * FROM sach WHERE maloai = ? AND masach != ? ORDER BY NgayNhap DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            ps.setString(2, maSach);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachLienQuan(String maLoai,String maSach) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TOP(4) * FROM sach WHERE maloai = ? AND masach != ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            ps.setString(2, maSach);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachLienQuan2(String maLoai,String maSach) {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TOP(4) * FROM sach WHERE maloai = ? AND masach != ? ORDER BY masach DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            ps.setString(2, maSach);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachMoiNhatTrangChu() {
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TOP(6) * FROM sach WHERE maloai = 'Tin' ORDER BY NgayNhap DESC ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SachBean> getListSachGiaRe() {
        Connection connection = DBConnect.getConnection();
        String sql = "  SELECT TOP(3) * FROM sach WHERE maloai = 'Tin' AND gia <= 35000 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> TimKiem(String key) {
        Connection connection = DBConnect.getConnection();
        String sql = "  SELECT s.*, l.tenloai FROM sach AS s INNER JOIN loai AS l ON l.maloai = s.maloai WHERE tensach LIKE ? OR tacgia LIKE ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+key+"%");
            ps.setString(2, "%"+key+"%");
            ResultSet rs = ps.executeQuery();
            ArrayList<SachBean> list = new ArrayList<>();
            while(rs.next()) {
                SachBean sach = new SachBean();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tacgia"));
                sach.setSoLuong(rs.getLong("soluong"));
                sach.setGia(rs.getLong("gia"));
                sach.setSoTap(rs.getString("sotap"));
                sach.setAnh(rs.getString("anh"));
                sach.setMaLoai(rs.getString("maloai"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                sach.setTenLoai(rs.getString("tenloai"));
                list.add(sach);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SachBean> getListSachByPage(ArrayList<SachBean> arr, int start, int end) {
        ArrayList<SachBean> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
    
  
    
}
