package Bean;

public class ThongKeHoaDonBean {
    private String hoTen;
    private String tenSach;
    private Long soLuongMua;
    private Long gia;
    private Long thanhTien;
    private Boolean tinhTrang;
    public ThongKeHoaDonBean() {}
    public ThongKeHoaDonBean(String hoTen, String tenSach, Long soLuongMua,
            Long gia, Long thanhTien, Boolean tinhTrang) {
        super();
        this.hoTen = hoTen;
        this.tenSach = tenSach;
        this.soLuongMua = soLuongMua;
        this.gia = gia;
        this.thanhTien = thanhTien;
        this.tinhTrang = tinhTrang;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public Long getSoLuongMua() {
        return soLuongMua;
    }
    public void setSoLuongMua(Long soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
    public Long getGia() {
        return gia;
    }
    public void setGia(Long gia) {
        this.gia = gia;
    }
    public Long getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(Long thanhTien) {
        this.thanhTien = thanhTien;
    }
    public Boolean getTinhTrang() {
        return tinhTrang;
    }
    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
  
  
    
}
