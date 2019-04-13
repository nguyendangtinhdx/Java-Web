package Bo;


import java.util.ArrayList;

import Bean.ChiTietHoaDonBean;
import Dao.ChiTietHoaDonDao;

public class ChiTietHoaDonBo {
    ChiTietHoaDonDao cthd = new ChiTietHoaDonDao();
    public int themChiTietHoaDon(ChiTietHoaDonBean chiTietHoaDon) {
        return cthd.themChiTietHoaDon(chiTietHoaDon);
    }
    public ArrayList<ChiTietHoaDonBean> getListChiTietHoaDon(){
        return cthd.getListChiTietHoaDon();
    }
    public boolean xoaChiTietHoaDon(String maChiTietHoaDon) {
        return cthd.xoaChiTietHoaDon(maChiTietHoaDon);
    }
    public boolean suaChiTietHoaDon(Long maCTHD,Long soLuong) {
        return cthd.suaChiTietHoaDon(maCTHD,soLuong);
    }
}
