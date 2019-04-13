package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.SachBean;

public class SachDao {
    public ArrayList<SachBean> getSach(){ // lấy  sách theo mã
        CoSo cs = new CoSo();
        try { // tạo ra 1 mảng để lưu trữ
            ArrayList<SachBean> ds = new ArrayList<SachBean>();
            cs.KetNoi();
            String sql = "SELECT TOP(6) * FROM sach  ORDER BY NgayNhap DESC  ";
            PreparedStatement ps = cs.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
                
                ds.add(sach);
            }
            rs.close();
            cs.con.close();
            return ds;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<SachBean> getSachByLoai(String maLoai){ // lấy  sách theo mã
        CoSo cs = new CoSo();
        try { // tạo ra 1 mảng để lưu trữ
            ArrayList<SachBean> ds = new ArrayList<SachBean>();
            cs.KetNoi();
            String sql = "SELECT TOP(6) * FROM sach WHERE maloai = ?  ORDER BY NgayNhap DESC  ";
            PreparedStatement ps = cs.con.prepareStatement(sql);
            ps.setString(1, maLoai);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                SachBean sach = new SachBean(rs.getString("masach"),rs.getString("tensach"),rs.getString("tacgia"),
                        rs.getLong("soluong"),rs.getLong("gia"),rs.getString("sotap"),rs.getString("anh"),rs.getDate("NgayNhap"),
                        rs.getString("maloai"));
                ds.add(sach);
            }
            rs.close();
            cs.con.close();
            return ds;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<SachBean> TimKiem(String tenSach){ 
        CoSo cs = new CoSo();
        try { // tạo ra 1 mảng để lưu trữ
            ArrayList<SachBean> ds = new ArrayList<SachBean>();
            cs.KetNoi();
            String sql = " SELECT * FROM sach WHERE tensach LIKE ? ";
          /*  String sql = "  SELECT * FROM sach WHERE tensach LIKE N'%" + tenSach+ "%' ";*/
            PreparedStatement ps = cs.con.prepareStatement(sql);
            ps.setString(1, "%"+tenSach+"%");
            ResultSet rs = ps.executeQuery();
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
                ds.add(sach);
            }
            rs.close();
            cs.con.close();
            return ds;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
}
