package bo;

import java.util.ArrayList;

import bean.DonViUngHoBEAN;
import dao.DonViUngHoDAO;

public class DonViUngHoBO {
    DonViUngHoDAO  donViUngHo = new DonViUngHoDAO();
    public ArrayList<DonViUngHoBEAN> getListDonViUngHo(){
        return donViUngHo.getListDonViUngHo();
    }
}
