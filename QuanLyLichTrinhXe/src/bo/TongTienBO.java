package bo;

import java.util.ArrayList;

import bean.TongTienBEAN;
import dao.TongTienDAO;
/**
* TongTienBO
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
public class TongTienBO {
    TongTienDAO tongTienDAO = new TongTienDAO();
    public ArrayList<TongTienBEAN> getListTongTien(){
        return tongTienDAO.getListTongTien();
    }
}
