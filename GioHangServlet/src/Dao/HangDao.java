package Dao;

import java.util.ArrayList;

import Bean.HangBean;

public class HangDao {
    
    public ArrayList<HangBean> getHang()
    {
        ArrayList<HangBean> ds = new ArrayList<HangBean>();
        HangBean h1 = new HangBean("01", "but bi", (long) 3, (long)2000, "a1.jpg");
        ds.add(h1);
        h1 = new HangBean("02", "vo", (long)3, (long)2000, "a4.jpg");
        ds.add(h1);
        h1 = new HangBean("03", "sach", (long)3, (long)2000, "a3.jpg");
        ds.add(h1);
        h1 = new HangBean("04", "bang", (long)3, (long)2000, "a5.jpg");
        ds.add(h1);
        return ds;
    }

}
