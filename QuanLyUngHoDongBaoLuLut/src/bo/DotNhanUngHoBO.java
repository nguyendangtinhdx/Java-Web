package bo;

import java.util.ArrayList;

import bean.DotNhanUngHoBEAN;
import dao.DotNhanUngHoDAO;

public class DotNhanUngHoBO {
    DotNhanUngHoDAO dotNhanUngHo = new DotNhanUngHoDAO();
    public ArrayList<DotNhanUngHoBEAN> getListDotNhanUngHo(){
        return dotNhanUngHo.getListDotNhanUngHo();
    }
}
