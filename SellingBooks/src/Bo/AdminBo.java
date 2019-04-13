package Bo;

import java.util.ArrayList;

import Bean.AdminBean;
import Dao.AdminDao;

public class AdminBo {
    AdminDao admin = new AdminDao();
    public ArrayList<AdminBean> getListAdmin(){
        return admin.getListAdmin();
    }
    public boolean themTaiKhoan(AdminBean a) {
        return admin.themTaiKhoan(a);
    }
    public boolean suaTaiKhoan(AdminBean a) {
        return admin.suaTaiKhoan(a);
    }
    public boolean xoaTaiKhoan(String tenDangNhap) {
        return admin.xoaTaiKhoan(tenDangNhap);
    }
    public AdminBean dangNhap(String tenDangNhap, String matKhau) {
        return admin.dangNhap(tenDangNhap, matKhau);
    }
}
