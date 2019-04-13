package Bo;

import java.util.HashMap;
import java.util.Map;

import Bean.HangBean;

public class GioHangBo {
private HashMap<String, HangBean> hang;
    
    public GioHangBo() {
        hang = new HashMap<>();
    }

    public GioHangBo(HashMap<String, HangBean> hang) {
        super();
        this.hang = hang;
    }

    public HashMap<String, HangBean> getHang() {
        return hang;
    }

    public void setHang(HashMap<String, HangBean> hang) {
        this.hang = hang;
    }
    
    public void them(String key, HangBean item) {
        boolean check = hang.containsKey(key);
        if (check) {
             long SoLuongCu = item.getSoLuong();
             item.setSoLuong(SoLuongCu + 1);
             hang.put(key, item);
        } else {
             hang.put(key, item);
        }
    }
    
    public void cong(String key, HangBean item, long sl) {
        boolean check = hang.containsKey(key);
        if (check) {
             long SoLuongCu = item.getSoLuong();
             item.setSoLuong(SoLuongCu + sl);
             hang.put(key, item);
        } else {
             hang.put(key, item);
        }
    }
 
     public void tru(String key, HangBean item, long sl) {
         boolean check = hang.containsKey(key);
         if (check) {
              long SoLuongCu = item.getSoLuong();
              item.setSoLuong(SoLuongCu - sl);
              hang.put(key, item);
         } else {
              hang.put(key, item);
         }
     }
     
     public void xoa(String key) {
         boolean check = hang.containsKey(key);
         if (check) {
              hang.remove(key);
         }
     }
     
     
     public int countItem() {
         return hang.size();
         
     }
     public double totalCart() {
         double count = 0;
         for(Map.Entry<String, HangBean> list : hang.entrySet()) {
             count += list.getValue().getSach().getGia() * list.getValue().getSoLuong();
         }
         return count;
     }
}
