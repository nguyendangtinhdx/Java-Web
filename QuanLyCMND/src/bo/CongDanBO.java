package bo;

import java.util.ArrayList;

import bean.CongDanBEAN;
import dao.CongDanDAO;

public class CongDanBO {
    CongDanDAO congDan = new CongDanDAO();
    public ArrayList<CongDanBEAN> getListCongDan(){
        return congDan.getListCongDan();
    }
    public boolean checkMa(String cmndID) {
        return congDan.checkMa(cmndID);
    }
    public boolean themCongDan(CongDanBEAN cd) {
        return congDan.themCongDan(cd);
    }
}
