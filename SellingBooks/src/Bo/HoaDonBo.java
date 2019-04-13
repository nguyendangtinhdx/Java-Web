package Bo;

import java.util.ArrayList;

import Bean.HoaDonBean;
import Dao.HoaDonDao;

public class HoaDonBo {
    HoaDonDao hoadon = new HoaDonDao();
    public int themHoaDon(HoaDonBean hoaDon) {
        return hoadon.themHoaDon(hoaDon);
    }
    public ArrayList<HoaDonBean> getListHoaDon(){
        return hoadon.getListHoaDon();
    }
    public boolean xoaHoaDon(String maHoaDon) {
        return hoadon.xoaHoaDon(maHoaDon);
    }
    public boolean xacNhanHoaDon(String maHoaDon) {
        return hoadon.xacNhanHoaDon(maHoaDon);
    }
}
