package Bo;

import java.util.ArrayList;

import Bean.MayTinhBean;
import Dao.MayTinhDao;

public class MayTinhBo {
    MayTinhDao maytinh = new MayTinhDao();
    public ArrayList<MayTinhBean> getListMayTinhByHang(String maHang){
        return maytinh.getListMayTinhByHang(maHang);
    }
    public ArrayList<MayTinhBean> getListMayTinhByKey(String key){
        return maytinh.getListMayTinhByKey(key);
    }
}
