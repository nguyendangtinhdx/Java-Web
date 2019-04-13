package bo;

import java.util.ArrayList;

import bean.LoaiXeBEAN;
import dao.LoaiXeDAO;

/**
* LoaiXeBO
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
public class LoaiXeBO {
    LoaiXeDAO loaiXeDAO = new LoaiXeDAO();
    public ArrayList<LoaiXeBEAN> getListLoaiXe(){
        return loaiXeDAO.getListLoaiXe();
    }
}
