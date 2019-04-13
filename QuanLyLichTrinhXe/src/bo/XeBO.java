package bo;

import java.util.ArrayList;

import bean.XeBEAN;
import dao.XeDAO;
/**
* XeBO
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
public class XeBO {
    XeDAO xeDAO = new XeDAO();
    public ArrayList<XeBEAN> getListXe(){
        return xeDAO.getListXe();
    }
    public boolean themXe(XeBEAN m) {
        return xeDAO.themXe(m);
    }
}
