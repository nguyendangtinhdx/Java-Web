package bo;

import java.util.ArrayList;

import bean.MayTinhBEAN;
import dao.MayTinhDAO;
/**
 * MayTinhBO
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
public class MayTinhBO {
    MayTinhDAO mayTinhDAO = new MayTinhDAO();
    public ArrayList<MayTinhBEAN> getListMay(){
        return mayTinhDAO.getListMay();
    }
    public boolean checkMa(String ma) {
        return mayTinhDAO.checkMa(ma);
    }
    public boolean themMay(MayTinhBEAN m) {
        return mayTinhDAO.themMay(m);
    }
    public boolean suaMay(MayTinhBEAN m) {
        return mayTinhDAO.suaMay(m);
    }
    public boolean xoaMay(String ma) {
        return mayTinhDAO.xoaMay(ma);
    }
    public ArrayList<MayTinhBEAN> timKiemMay(String key){
        return mayTinhDAO.timKiemMay(key);
    }
}
