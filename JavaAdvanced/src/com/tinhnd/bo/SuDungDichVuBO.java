package com.tinhnd.bo;

import java.util.ArrayList;

import com.tinhnd.bean.SuDungDichVuBEAN;
import com.tinhnd.dao.SuDungDichVuDAO;

public class SuDungDichVuBO {
    SuDungDichVuDAO suDungDichVuDAO = new SuDungDichVuDAO();
    public ArrayList<SuDungDichVuBEAN> getListSuDungDichVu(){
        return suDungDichVuDAO.getListSuDungDichVu();
    }
    public boolean themSuDungDichVu(SuDungDichVuBEAN dv) {
        return suDungDichVuDAO.themSuDungDichVu(dv);
    }
}
