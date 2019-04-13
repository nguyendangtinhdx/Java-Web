package Bean;

public class HangBean {
    private String maHang;
    private String tenHang;
    private long soLuong;
    private long gia;
    private long thanhTien;
    private String hinhAnh;
    public HangBean(String maHang, String tenHang, long soLuong, long gia,
           String hinhAnh) {
        super();
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = soLuong*gia;
        this.hinhAnh = hinhAnh;
    }
    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    public long getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }
    public long getGia() {
        return gia;
    }
    public void setGia(long gia) {
        this.gia = gia;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
}
