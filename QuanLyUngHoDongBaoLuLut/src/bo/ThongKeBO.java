package bo;

import java.util.ArrayList;

import bean.ThongKeBEAN;
import dao.ThongKeDAO;

public class ThongKeBO {
    ThongKeDAO thongKe = new ThongKeDAO();
    public ArrayList<ThongKeBEAN> getListThongKe(){
        return thongKe.getListThongKe();
    }
}
