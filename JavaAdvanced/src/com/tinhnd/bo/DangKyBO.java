package com.tinhnd.bo;

import java.util.ArrayList;

import com.tinhnd.bean.DangKyBEAN;
import com.tinhnd.dao.DangKyDAO;

public class DangKyBO {
    DangKyDAO dangKyDAO = new DangKyDAO();
    public ArrayList<DangKyBEAN> getListDangKy(){
        return dangKyDAO.getListDangKy();
    }
    public ArrayList<DangKyBEAN> getListDangKyByPage(ArrayList<DangKyBEAN> arr, int start, int end) {
        return dangKyDAO.getListDangKyByPage(arr, start, end);
    }
}
