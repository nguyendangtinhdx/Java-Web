package com.tinhnd.bean;

import java.util.Date;

public class DangKyBEAN {
    private String maKH;
    private String tenKH;
    private String maMay;
    private String viTri;
    private String trangThai;
    private Date ngayBatDauSuDung;
    private String gioBatDauSuDung;
    private String thoiGianSuDung;
    private String maDV;
    private Date ngaySuDung;
    private String gioSuDung;
    private int soLuong;
    private int tongTien;
    public DangKyBEAN() {}
    public DangKyBEAN(String maKH, String tenKH, String maMay, String viTri,
            String trangThai, Date ngayBatDauSuDung, String gioBatDauSuDung,
            String thoiGianSuDung, String maDV, Date ngaySuDung, String gioSuDung,
            int soLuong, int tongTien) {
        super();
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maMay = maMay;
        this.viTri = viTri;
        this.trangThai = trangThai;
        this.ngayBatDauSuDung = ngayBatDauSuDung;
        this.gioBatDauSuDung = gioBatDauSuDung;
        this.thoiGianSuDung = thoiGianSuDung;
        this.maDV = maDV;
        this.ngaySuDung = ngaySuDung;
        this.gioSuDung = gioSuDung;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
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
    public String getMaMay() {
        return maMay;
    }
    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }
    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Date getNgayBatDauSuDung() {
        return ngayBatDauSuDung;
    }
    public void setNgayBatDauSuDung(Date ngayBatDauSuDung) {
        this.ngayBatDauSuDung = ngayBatDauSuDung;
    }
    public String getGioBatDauSuDung() {
        return gioBatDauSuDung;
    }
    public void setGioBatDauSuDung(String gioBatDauSuDung) {
        this.gioBatDauSuDung = gioBatDauSuDung;
    }
    public String getThoiGianSuDung() {
        return thoiGianSuDung;
    }
    public void setThoiGianSuDung(String thoiGianSuDung) {
        this.thoiGianSuDung = thoiGianSuDung;
    }
    public String getMaDV() {
        return maDV;
    }
    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }
    public Date getNgaySuDung() {
        return ngaySuDung;
    }
    public void setNgaySuDung(Date ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }
    public String getGioSuDung() {
        return gioSuDung;
    }
    public void setGioSuDung(String gioSuDung) {
        this.gioSuDung = gioSuDung;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public int getTongTien() {
        return tongTien;
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
