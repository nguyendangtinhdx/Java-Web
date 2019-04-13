package Bo;

import java.util.ArrayList;

import Bean.ThongKeHoaDonBean;
import Dao.ThongKeHoaDonDao;

public class ThongKeHoaDonBo {
   ThongKeHoaDonDao thongke = new ThongKeHoaDonDao();
   public ArrayList<ThongKeHoaDonBean> getListThongKeHoaDon(String hoten){
       return thongke.getListThongKeHoaDon(hoten);
   }
}
