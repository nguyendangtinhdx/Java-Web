package Bean;

public class Hang {
	private String TenHang;
	private Float Gia;
	private int SoLuong;
	public Hang(String tenHang, Float gia, int soLuong) {
		super();
		TenHang = tenHang;
		Gia = gia;
		SoLuong = soLuong;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public Float getGia() {
		return Gia;
	}
	public void setGia(Float gia) {
		Gia = gia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}	
}
