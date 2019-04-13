package Bean;

public class ChiTietHoaDonBean {
    private Long maChiTietHoaDon;
    private String maSach;
    private Long soLuongMua;
    private Long maHoaDon;
    private Float gia;
    private String tenSach;
    public ChiTietHoaDonBean() {}
    public ChiTietHoaDonBean(Long maChiTietHoaDon, String maSach,
            Long soLuongMua, Long maHoaDon, Float gia) {
        super();
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.maSach = maSach;
        this.soLuongMua = soLuongMua;
        this.maHoaDon = maHoaDon;
        this.gia = gia;
    }
    public Long getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }
    public void setMaChiTietHoaDon(Long maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public Long getSoLuongMua() {
        return soLuongMua;
    }
    public void setSoLuongMua(Long soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
    public Long getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(Long maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    public Float getGia() {
        return gia;
    }
    public void setGia(Float gia) {
        this.gia = gia;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
  
   
    
}
