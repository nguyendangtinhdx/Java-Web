package bo;

import java.util.ArrayList;

import bean.ChiTietDotUngHoBEAN;
import dao.ChiTietDotUngHoDAO;

public class ChiTietDotUngHoBO {
    ChiTietDotUngHoDAO chiTietDotUngHo = new ChiTietDotUngHoDAO();
    public ArrayList<ChiTietDotUngHoBEAN> getListChiTietDotUngHo(){
        return chiTietDotUngHo.getListChiTietDotUngHo();
    }
    public boolean checkMa(String hinhThucUngHo) {
        return chiTietDotUngHo.checkMa(hinhThucUngHo);
    }
    public boolean themChiTietDotUngHo(ChiTietDotUngHoBEAN ctduh) {
        return chiTietDotUngHo.themChiTietDotUngHo(ctduh);
    }
    public boolean suaChiTietDotUngHo(ChiTietDotUngHoBEAN ctduh) {
        return chiTietDotUngHo.suaChiTietDotUngHo(ctduh);
    }
    public boolean xoaChiTietHoatDong(String hinhThucUngHo) {
        return chiTietDotUngHo.xoaChiTietHoatDong(hinhThucUngHo);
    }
}
