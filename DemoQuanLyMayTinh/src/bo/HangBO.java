package bo;
/**
 * HangBO
 * 
 * Version 1.0
 * 
 * Date 7-3-2018
 * 
 * Copyright
 * 
 * Modification logs DATE AUTHOR DESCRIPTION
 * ------------------------------------------------ 7-3-2018 TỉnhND Create
 *
 */

import java.util.ArrayList;

import bean.HangBEAN;
import dao.HangDAO;

public class HangBO {
    HangDAO hangDAO = new HangDAO();
    public ArrayList<HangBEAN> getListHang(){
        return hangDAO.getListHang();
    }
}
