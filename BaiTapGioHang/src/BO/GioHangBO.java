package BO;

import java.util.ArrayList;

import Bean.GioHangBean;

public class GioHangBO {
    public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
    public void Add(String maHang , String tenHang, long gia, int soLuong) {
        for(int i = 0;i < ds.size();i++){
            if(ds.get(i).getMaHang().equals(maHang)){
                int slt = ds.get(i).getSoLuong() + soLuong;
                ds.get(i).setSoLuong(slt);
                return;
            }
        }
        GioHangBean gio = new GioHangBean(maHang, tenHang, gia, soLuong);
        ds.add(gio);
    }
    public void Remove(String value) {
        for(int i = 0 ; i< ds.size() ; i++)
        {
            if(ds.get(i).getMaHang().equals(value)){
                ds.remove(i);
                break;
            }
        }
    }
}
