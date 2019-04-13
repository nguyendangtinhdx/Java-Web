package Bo;

import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.LoaiDao;

public class LoaiBo {
    LoaiDao loai = new LoaiDao();
    public ArrayList<LoaiBean> getListLoai(){
        return loai.getListLoai();
    }
    public ArrayList<LoaiBean> getListLoaiTuNhien(){
        return loai.getListLoaiTuNhien();
    }
    public ArrayList<LoaiBean> getListLoaiXaHoi(){
        return loai.getListLoaiXaHoi();
    }
    public boolean themLoai(LoaiBean l) {
        return loai.themLoai(l);
    }
    public boolean suaLoai(LoaiBean l) {
        return loai.suaLoai(l);
    }
    public boolean xoaLoai(String maLoai) {
        return loai.xoaLoai(maLoai);
    }
    
}
