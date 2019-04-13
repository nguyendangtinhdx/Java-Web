package Bean;

import java.sql.Timestamp;

public class HoaDonBean {
    private Long maHoaDon;
    private Long maKhachHang;
    private Timestamp ngayMua;
    private boolean daMua;
    private String hoTen;
    public HoaDonBean() { }
    public HoaDonBean(Long maHoaDon, Long maKhachHang, Timestamp ngayMua,
            boolean daMua, String hoTen) {
        super();
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayMua = ngayMua;
        this.daMua = daMua;
        this.hoTen = hoTen;
    }
    public Long getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(Long maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    public Long getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(Long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public Timestamp getNgayMua() {
        return ngayMua;
    }
    public void setNgayMua(Timestamp ngayMua) {
        this.ngayMua = ngayMua;
    }
    public boolean isDaMua() {
        return daMua;
    }
    public void setDaMua(boolean daMua) {
        this.daMua = daMua;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
   
    
}
