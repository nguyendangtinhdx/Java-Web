package bean;
/**
 * HangBEAN
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
public class HangBEAN {
    private String maHang;
    private String tenHang;
    public HangBEAN() {}
    public HangBEAN(String maHang, String tenHang) {
        super();
        this.maHang = maHang;
        this.tenHang = tenHang;
    }
    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
}
