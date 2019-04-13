package com.tinhnd.bo;

import java.util.ArrayList;

import com.tinhnd.bean.MayBEAN;
import com.tinhnd.dao.MayDAO;

public class MayBO {
    MayDAO mayDAO = new MayDAO();
    public ArrayList<MayBEAN> getListMay(){
        return mayDAO.getListMay();
    }
    public boolean checkMaMay(String maMay) {
        return mayDAO.checkMaMay(maMay);
    }
    public boolean themMay(MayBEAN m) {
        return mayDAO.themMay(m);
    }
    public boolean suaMay(MayBEAN m) {
        return mayDAO.suaMay(m);
    }
    public boolean xoaMay(String maMay) {
        return mayDAO.xoaMay(maMay);
    }
    public ArrayList<MayBEAN> timKiemMay(String key){
        return mayDAO.timKiemMay(key);
    }
    public ArrayList<MayBEAN> getListMayByPage(ArrayList<MayBEAN> arr, int start, int end) {
        return mayDAO.getListMayByPage(arr, start, end);
    }
}
