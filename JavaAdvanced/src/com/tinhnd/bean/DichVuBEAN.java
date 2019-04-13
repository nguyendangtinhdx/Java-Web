package com.tinhnd.bean;

public class DichVuBEAN {
    private String maDV;
    private String tenDV;
    private String donViTinh;
    private int donGia;
    public DichVuBEAN() {}
    public DichVuBEAN(String maDV, String tenDV, String donViTinh, int donGia) {
        super();
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
    }
    public String getMaDV() {
        return maDV;
    }
    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }
    public String getTenDV() {
        return tenDV;
    }
    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }
    public String getDonViTinh() {
        return donViTinh;
    }
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    public int getDonGia() {
        return donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
