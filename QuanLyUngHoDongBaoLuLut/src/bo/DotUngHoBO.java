package bo;

import java.util.ArrayList;

import bean.DotUngHoBEAN;
import dao.DotUngHoDAO;

public class DotUngHoBO {
    DotUngHoDAO dotUngHo = new DotUngHoDAO();
    public ArrayList<DotUngHoBEAN> getListDotUngHo(){
        return dotUngHo.getListDotUngHo();
    }
    public boolean checkMa(String maDotUngHo) {
        return dotUngHo.checkMa(maDotUngHo);
    }
    public boolean themDotUngHo(DotUngHoBEAN duh) {
        return dotUngHo.themDotUngHo(duh);
    }
    public boolean suaDotUngHo(DotUngHoBEAN duh) {
        return dotUngHo.suaDotUngHo(duh);
    }
    public boolean xoaHoatDong(String maDotUngHo) {
        return dotUngHo.xoaHoatDong(maDotUngHo);
    }
}
