package bo;

import java.util.ArrayList;

import bean.NhaXeBEAN;
import dao.NhaXeDAO;
/**
* NhaXeBO
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
public class NhaXeBO {
    NhaXeDAO nhaXeDAO = new NhaXeDAO();
    public ArrayList<NhaXeBEAN> getListNhaXe(){
        return nhaXeDAO.getListNhaXe();
    }
}
