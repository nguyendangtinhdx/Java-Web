package DAO;

import java.util.ArrayList;

import Bean.HangBean;

public class HangDAO {
    public ArrayList<HangBean> getHang(){
        ArrayList<HangBean> ds = new ArrayList<>();
        HangBean h1 = new HangBean("01", "mu", (long)1,( long)16500,"Img/sach.jpg");
        ds.add(h1);
        h1 = new HangBean("02", "ao", (long)14,( long)15000,"Img/sach2.jpg");
        ds.add(h1);
        h1= new HangBean("03", "quan", (long)2,( long)11000,"Img/sach3.jpg");
        ds.add(h1);
        h1 = new HangBean("04", "nhan", (long)6,( long)18000,"Img/sach4.jpg");
        ds.add(h1);
        h1 = new HangBean("05", "dongho", (long)2,( long)10000,"Img/sach5.jpg");
        ds.add(h1);
        
        return ds;
    }
}
