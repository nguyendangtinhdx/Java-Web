package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import Dao.SachDao;


public class SachBo {
    SachDao sach = new SachDao();
    public ArrayList<SachBean> getListSach(){
        return sach.getListSach();
    }
    public ArrayList<SachBean> getListSachByLoai(String maLoai){
        return sach.getListSachByLoai(maLoai);
    }
    public ArrayList<SachBean> getListSachByPage(ArrayList<SachBean> arr, int start, int end) {
        return sach.getListSachByPage(arr, start, end);
    }
    
    public ArrayList<SachBean> getListSachMoiNhatTrangChu() {
        return sach.getListSachMoiNhatTrangChu();
    }
    
    public ArrayList<SachBean> getListSachGiaRe() {
        return sach.getListSachGiaRe();
    }
    
    public ArrayList<SachBean> getListSachKhoaHoc(){
        return sach.getListSachKhoaHoc();
    }
    public ArrayList<SachBean> getListSachToanHoc(){
        return sach.getListSachToanHoc();
    }
    
    public ArrayList<SachBean> getListSachByLoaiMoiNhat(String maLoai) {
        return sach.getListSachByLoaiMoiNhat(maLoai);
    }
    
    public SachBean getSach(String maSach) {
        return sach.getSach(maSach);
    }
    public ArrayList<SachBean> getListSachMoiNhat(String maLoai,String maSach) {
        return sach.getListSachMoiNhat(maLoai, maSach);
    }
    
    public ArrayList<SachBean> getListSachLienQuan(String maLoai,String maSach) {
        return sach.getListSachLienQuan(maLoai, maSach);
    }
    
    public ArrayList<SachBean> getListSachLienQuan2(String maLoai,String maSach) {
        return sach.getListSachLienQuan2(maLoai, maSach);
    }
    public ArrayList<SachBean> TimKiem(String key) {
        return sach.TimKiem(key);
    }
    
    
}
