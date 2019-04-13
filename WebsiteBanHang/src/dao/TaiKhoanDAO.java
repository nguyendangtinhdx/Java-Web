package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.TaiKhoan;

public class TaiKhoanDAO {
    public static Map<String, TaiKhoan> mapTaiKhoan= loadData();
    public TaiKhoanDAO() {
        
    }
    private static Map<String, TaiKhoan> loadData() {
       Map<String , TaiKhoan> mapTemp = new HashMap<>();
       try {
        ResultSet rs = new ConnectToDatabase().selectData("SELECT  * FROM Taikhoan");
        while(rs.next()) {
            String tenTaiKhoan = rs.getString(1);
            String matKhau = rs.getString(2);
            String tenKhachHang = rs.getString(3);
            String gioiTinh = rs.getString(4);
            String soDienThoai = rs.getString(5);
            String email = rs.getString(6);
            String ngaySinh= rs.getString(7);
            String diaChi = rs.getString(8);
            String soLuongMua= rs.getString(9);
            String role= rs.getString(10);
            TaiKhoan tk = new TaiKhoan(tenTaiKhoan, matKhau, tenKhachHang, gioiTinh, soDienThoai, email, ngaySinh, diaChi, soLuongMua, role);
            mapTemp.put(tk.getTenTaiKhoan(),tk);
        }
       } catch (Exception e) {
        e.printStackTrace();
    }
       return mapTemp;
    }
    public boolean checkLogin(String userName, String passWord) {
        TaiKhoan tk = mapTaiKhoan.get(userName);
        if(tk != null) { // tài khoản có trong map
            if(tk.getMatKhau().equals(passWord)) { // lấy password ra kiểm tra
                return true;
            }
            else {
                return false;
            }
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        TaiKhoanDAO tkDao = new TaiKhoanDAO();
        System.out.println(tkDao.mapTaiKhoan);
        System.out.println(tkDao.checkLogin("anhdinh","anhdinh11"));
        System.out.println(tkDao.checkLogin("hiendi","hiendi"));
        System.out.println(tkDao.checkLogin("anhdinh","anhdinh1"));
    }
    
    
}
