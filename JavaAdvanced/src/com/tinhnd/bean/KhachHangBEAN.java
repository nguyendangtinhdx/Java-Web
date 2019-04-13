package com.tinhnd.bean;

public class KhachHangBEAN {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String soDienThoai;
    private String diaChiEmail;
    public KhachHangBEAN() { }
    public KhachHangBEAN(String maKH, String tenKH, String diaChi,
            String soDienThoai, String diaChiEmail) {
        super();
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.diaChiEmail = diaChiEmail;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getDiaChiEmail() {
        return diaChiEmail;
    }
    public void setDiaChiEmail(String diaChiEmail) {
        this.diaChiEmail = diaChiEmail;
    }
    
}
