package com.tinhnd.bean;

import java.util.Date;

public class SuDungDichVuBEAN {
    private String maKH;
    private String maDV;
    private Date ngaySuDung;
    private String gioSuDung;
    private int soLuong;
    public SuDungDichVuBEAN(String maKH, String maDV, Date ngaySuDung,
            String gioSuDung, int soLuong) {
        super();
        this.maKH = maKH;
        this.maDV = maDV;
        this.ngaySuDung = ngaySuDung;
        this.gioSuDung = gioSuDung;
        this.soLuong = soLuong;
    }
    public SuDungDichVuBEAN() {}
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
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
    public void setGioSuDung(String gsd) {
        this.gioSuDung = gsd;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
