package Bo;

import java.util.ArrayList;

import Bean.ThongKeBean;
import Dao.ThongKeDao;

public class ThongKeBo {
    ThongKeDao thongke = new ThongKeDao();
    public ArrayList<ThongKeBean> getListThongKe(){
        return thongke.getListThongKe();
    }
}
