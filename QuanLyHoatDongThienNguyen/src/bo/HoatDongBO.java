package bo;

import java.util.ArrayList;

import bean.HoatDongBEAN;
import dao.HoatDongDAO;

public class HoatDongBO {
    HoatDongDAO hoatDong = new HoatDongDAO();
    public ArrayList<HoatDongBEAN> getListHoatDong(){
        return hoatDong.getListHoatDong();
    }
    public boolean checkMa(String maHoatDong) {
        return hoatDong.checkMa(maHoatDong);
    }
    public boolean themHoatDong(HoatDongBEAN hd) {
        return hoatDong.themHoatDong(hd);
    }
    public boolean suaHoatDong(HoatDongBEAN hd) {
        return hoatDong.suaHoatDong(hd);
    }
    public boolean xoaHoatDong(String maHD) {
        return hoatDong.xoaHoatDong(maHD);
    }
}
