package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.LoaiBean;

public class LoaiDao {
    public ArrayList<LoaiBean> getLoai(){
        try { // tạo ra 1 mảng để lưu trữ
            ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
            CoSo cs = new CoSo();
            cs.KetNoi();
            ResultSet rs = cs.getBang("loai");
            while(rs.next()) {
                LoaiBean loai = new LoaiBean(rs.getString("maloai"), rs.getString("tenloai"));
                ds.add(loai);
            }
            rs.close();
            cs.con.close();
            return ds;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
