package bo;

import java.util.ArrayList;

import bean.ThanhVienBEAN;
import dao.ThanhVienDAO;

public class ThanhVienBO {
    ThanhVienDAO thanhVien = new ThanhVienDAO();
    public ArrayList<ThanhVienBEAN> getListThanhVien(){
        return thanhVien.getListThanhVien();
    }
}
