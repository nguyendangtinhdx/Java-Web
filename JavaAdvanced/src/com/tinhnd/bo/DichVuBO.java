package com.tinhnd.bo;

import java.util.ArrayList;

import com.tinhnd.bean.DichVuBEAN;
import com.tinhnd.dao.DichVuDAO;

public class DichVuBO {
    DichVuDAO dichVuDAO = new DichVuDAO();
    public ArrayList<DichVuBEAN> getListDichVu(){
        return dichVuDAO.getListDichVu();
    }
    public boolean checkMaDV(String maDV) {
        return dichVuDAO.checkMaDV(maDV);
    }
    public boolean themDichVu(DichVuBEAN dv) {
        return dichVuDAO.themDichVu(dv);
    }
    public boolean suaDichVu(DichVuBEAN dv) {
        return dichVuDAO.suaDichVu(dv);
    }
    public boolean xoaDichVu(String maDV) {
        return dichVuDAO.xoaDichVu(maDV);
    }
    public ArrayList<DichVuBEAN> timKiemDichVu(String key){
        return dichVuDAO.timKiemDichVu(key);
    }
    public ArrayList<DichVuBEAN> getListDichVuByPage(ArrayList<DichVuBEAN> arr, int start, int end) {
        return dichVuDAO.getListDichVuByPage(arr, start, end);
    }
}
