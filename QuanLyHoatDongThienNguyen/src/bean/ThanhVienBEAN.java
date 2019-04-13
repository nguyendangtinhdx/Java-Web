package bean;

import java.util.Date;

public class ThanhVienBEAN {
    private String maThanhVien;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChiEmail;
    private String soDienThoai;
    public ThanhVienBEAN() { }
    public ThanhVienBEAN(String maThanhVien, String hoTen, boolean gioiTinh,
            Date ngaySinh, String diaChiEmail, String soDienThoai) {
        super();
        this.maThanhVien = maThanhVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChiEmail = diaChiEmail;
        this.soDienThoai = soDienThoai;
    }
    public String getMaThanhVien() {
        return maThanhVien;
    }
    public void setMaThanhVien(String maThanhVien) {
        this.maThanhVien = maThanhVien;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public boolean isGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getDiaChiEmail() {
        return diaChiEmail;
    }
    public void setDiaChiEmail(String diaChiEmail) {
        this.diaChiEmail = diaChiEmail;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
  
    
}
