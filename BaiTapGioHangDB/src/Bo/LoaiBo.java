package Bo;

import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.LoaiDao;

public class LoaiBo {
    LoaiDao loai = new LoaiDao();
    public ArrayList<LoaiBean> getLoai(){
        return loai.getLoai();
    }
}
