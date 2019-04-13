package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;

public class GioHangBo {
    public ArrayList<GioHangBean> gh = new ArrayList<GioHangBean>();
    
    public void add(String mahang, String tenhang, Long gia, Long soluong)
    {
        GioHangBean gio = new GioHangBean(mahang, tenhang, gia, soluong);
            gh.add(gio);
    }
    
    public void them(String mahang, String tenhang, Long gia, Long soluong)
    {
        if(gh!=null)
            for(GioHangBean h: gh)
                {
                    if(h.getTenhang().equalsIgnoreCase(tenhang))
                    {
                        h.setSoluong(h.getSoluong()+soluong);
                        return;
                    }   
                }
        GioHangBean gio = new GioHangBean(mahang, tenhang, gia, soluong);
        gh.add(gio);
    }
    
    public void tru(String tenhang, String txtsua)
    {
        if(gh!=null)
            for(GioHangBean h: gh)
                if(h.getMahang().equalsIgnoreCase(tenhang))
                    if(h.getSoluong()>Long.parseLong(txtsua))
                    {
                        h.setSoluong(h.getSoluong()-Long.parseLong(txtsua));
                        return;
                    }
        
    }
    public void cong(String tenhang, String txtsua)
    {
        if(gh!=null)
            for(GioHangBean h: gh)
                if(h.getMahang().equalsIgnoreCase(tenhang))
                {
                        h.setSoluong(h.getSoluong()+Long.parseLong(txtsua));
                        return;
                }
        
    }
    
    
    public void Xoa(String tenhang)
    {
        for(GioHangBean h: gh)
            if(h.getTenhang().equalsIgnoreCase(tenhang))
            {
                gh.remove(h);
                break;
            }
    }
}
