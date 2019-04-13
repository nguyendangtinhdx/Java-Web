package bo;

import java.util.ArrayList;

import bean.TuyenXeBEAN;
import dao.TuyenXeDAO;
/**
* TuyenXeBO
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
public class TuyenXeBO {
    TuyenXeDAO tuyenXeDAO = new TuyenXeDAO();
    public ArrayList<TuyenXeBEAN> getListTuyenXe(){
        return tuyenXeDAO.getListTuyenXe();
    }
}
