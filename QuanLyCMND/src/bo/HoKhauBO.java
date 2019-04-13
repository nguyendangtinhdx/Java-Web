package bo;

import java.util.ArrayList;

import bean.HoKhauBEAN;
import dao.HoKhauDAO;

public class HoKhauBO {
HoKhauDAO hoKhau = new HoKhauDAO();
public ArrayList<HoKhauBEAN> getListHoKhau(){
    return hoKhau.getListHoKhau();
}
public boolean suaHoKhau(HoKhauBEAN hd) {
    return suaHoKhau(hd);
}
}
