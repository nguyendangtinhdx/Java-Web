package bean;

import java.util.Date;
/**
 * MayTinhBEAN
 * 
 * Version 1.0
 * 
 * Date 7-3-2018
 * 
 * Copyright
 * 
 * Modification logs DATE AUTHOR DESCRIPTION
 * ------------------------------------------------ 7-3-2018 TỉnhND Create
 *
 */
public class MayTinhBEAN {
    private String ma;
    private String ten;
    private int gia;
    private int soLuong;
    private Date ngaySanXuat;
    private String maHang;
    public MayTinhBEAN() { }
    public MayTinhBEAN(String ma, String ten, int gia, int soLuong,
            Date ngaySanXuat, String maHang) {
        super();
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.maHang = maHang;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getGia() {
        return gia;
    }
    public void setGia(int gia) {
        this.gia = gia;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }
    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }
    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    
}
