package Bo;

import java.util.ArrayList;

import Bean.Hang;

public class HangBo {
	public ArrayList<Hang> ds = new ArrayList<Hang>();
	public void Them (String TenHang, Float Gia, int SoLuong){
		boolean kt = false;
		for(Hang h: ds)
		{
			if(h.getTenHang().contains(TenHang))
			{
				h.setSoLuong(h.getSoLuong()+SoLuong);
				kt = true;
			}
		}
		if(kt == false){
		Hang h = new Hang(TenHang,Gia,SoLuong);
		ds.add(h);
		}
	}
	public Float TongTien()
	{		
		Float tongtien = (float) 0;
		for(Hang h: ds)
		{
			tongtien = (float) h.getGia() * h.getSoLuong();
		}
		return tongtien;
	}
	public void Sua (String TenHang, int SoLuong){
		
	}
	public void Xoa (String TenHang){
		
	}
}
