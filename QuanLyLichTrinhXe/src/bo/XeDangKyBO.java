package bo;

import java.util.ArrayList;

import bean.LichTrinhXeBEAN;
import bean.XeDangKyBEAN;
import dao.XeDangKyDAO;
/**
 * XeDangKyBO
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
public class XeDangKyBO {
    XeDangKyDAO xeDangKyDAO = new XeDangKyDAO();
    public ArrayList<XeDangKyBEAN> getListXeDangKy(){
        return xeDangKyDAO.getListXeDangKy();
    }
    public ArrayList<XeDangKyBEAN> getListXeDangKyByKey(String key){
        return xeDangKyDAO.getListXeDangKyByKey(key);
    }
    public boolean themLichTrinhXe(LichTrinhXeBEAN m) {
        return xeDangKyDAO.themLichTrinhXe(m);
    }
}
