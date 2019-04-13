package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import Dao.SachDao;

public class SachBo {
    SachDao sach = new SachDao();
    public ArrayList<SachBean> getSachByLoai(String maLoai){
        return sach.getSachByLoai(maLoai);
    }
    public ArrayList<SachBean> getSach(){
        return sach.getSach();
    }
    public ArrayList<SachBean> TimKiem(String tenSach){
        return sach.TimKiem(tenSach);
    }
}
