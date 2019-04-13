package com.tinhnd.bean;

import java.util.Date;

public class SuDungMayBEAN {
    private String maKH;
    private String maMay;
    private Date ngayBatDauSuDung;
    private String gioBatDauSuDung;
    private String thoiGianSuDung;
    public SuDungMayBEAN() {}
    public SuDungMayBEAN(String maKH, String maMay, Date ngayBatDauSuDung,
            String gioBatDauSuDung, String thoiGianSuDung) {
        super();
        this.maKH = maKH;
        this.maMay = maMay;
        this.ngayBatDauSuDung = ngayBatDauSuDung;
        this.gioBatDauSuDung = gioBatDauSuDung;
        this.thoiGianSuDung = thoiGianSuDung;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getMaMay() {
        return maMay;
    }
    public void setMaMay(String maMay) {
        this.maMay = maMay;
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
    
}
