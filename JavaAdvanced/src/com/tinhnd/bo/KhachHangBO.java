package com.tinhnd.bo;

import java.util.ArrayList;

import com.tinhnd.bean.KhachHangBEAN;
import com.tinhnd.dao.KhachHangDAO;

public class KhachHangBO {
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    public ArrayList<KhachHangBEAN> getListKhachHang(){
        return khachHangDAO.getListKhachHang();
    }
    public boolean checkMaKhachHang(String maKhachHang) {
        return khachHangDAO.checkMaKhachHang(maKhachHang);
    }
    public boolean themKhachHang(KhachHangBEAN kh) {
        return khachHangDAO.themKhachHang(kh);
    }
    public boolean suaKhachHang(KhachHangBEAN kh) {
        return khachHangDAO.suaKhachHang(kh);
    }
    public boolean xoaKhachHang(String maKhachHang) {
        return khachHangDAO.xoaKhachHang(maKhachHang);
    }
    public ArrayList<KhachHangBEAN> timKiemKhachHang(String key){
        return khachHangDAO.timKiemKhachHang(key);
    }
    public ArrayList<KhachHangBEAN> getListKhachHangByPage(ArrayList<KhachHangBEAN> arr, int start, int end) {
        return khachHangDAO.getListKhachHangByPage(arr, start, end);
    }
    
}
