package Bo;

import java.util.ArrayList;

import Bean.KhachHangBean;
import Dao.KhachHangDao;

public class KhachHangBo {
    KhachHangDao khachhang = new KhachHangDao();
    public boolean checkTaiKhoan(String tenDangNhap) {
        return khachhang.checkTaiKhoan(tenDangNhap);
    }
    public boolean dangKy(KhachHangBean kh) {
        return khachhang.dangKy(kh);
    }
    public KhachHangBean dangNhap(String tenDangNhap, String matKhau) {
        return khachhang.dangNhap(tenDangNhap, matKhau);
    }
    public KhachHangBean getKhachHangByMaKhachHang(Long maKhacHang) {
        return khachhang.getKhachHangByMaKhachHang(maKhacHang);
    }
    public ArrayList<KhachHangBean> getListKhachHang(){
        return khachhang.getListKhachHang();
    }
    public boolean xoaKhachHang(String maKhachHang) {
        return khachhang.xoaKhachHang(maKhachHang);
    }
}
