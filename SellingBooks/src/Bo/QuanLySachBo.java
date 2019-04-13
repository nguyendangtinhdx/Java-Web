package Bo;

import java.util.ArrayList;

import Bean.QuanLySachBean;
import Dao.QuanLySachDao;

public class QuanLySachBo {
    QuanLySachDao dao = new QuanLySachDao();
    public ArrayList<QuanLySachBean> getListSach(){
        return dao.getListSach();
    }
    public ArrayList<QuanLySachBean> getListSachByPage(ArrayList<QuanLySachBean> arr, int start, int end) {
        return dao.getListSachByPage(arr, start, end);
    }
    public boolean themSach(QuanLySachBean s) {
        return dao.themSach(s);
    }
    
    public boolean suaSach(QuanLySachBean s) {
        return dao.suaSach(s);
    }
    
    public boolean xoaSach(String maSach) {
        return dao.xoaSach(maSach);
    }
}
