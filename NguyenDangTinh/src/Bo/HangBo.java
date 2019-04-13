package Bo;

import java.util.ArrayList;

import Bean.HangBean;
import Dao.HangDao;

public class HangBo {
    HangDao hang = new HangDao();
    public ArrayList<HangBean> getListHang(){
        return hang.getListHang();
    }
}
