package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.LichSuLuuTruBEAN;
import dao.LichSuLuuTruDAO;

public class LichSuLuuTruBO {
    LichSuLuuTruDAO lichSuLuuTru = new LichSuLuuTruDAO();
    public ArrayList<LichSuLuuTruBEAN> getListLichSuLuuTru(){
       return lichSuLuuTru.getListLichSuLuuTru();
    }
    public boolean xoaLichSu(Date n) {
        return xoaLichSu(n);
    }
}
