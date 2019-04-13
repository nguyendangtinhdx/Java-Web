package com.tinhnd.bo;

import com.tinhnd.bean.SuDungMayBEAN;
import com.tinhnd.dao.SuDungMayDAO;

public class SuDungMayBO {
    SuDungMayDAO suDungMayDAO = new SuDungMayDAO();
    public boolean themSuDungMay(SuDungMayBEAN m) {
        return suDungMayDAO.themSuDungMay(m);
    }
}
