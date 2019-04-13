package bean;
/**
 * TongTienBEAN
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
public class TongTienBEAN {
    private String maNhaXe;
    private String tenNhaXe;
    private int tongTien;
    public TongTienBEAN() {    }
    public TongTienBEAN(String maNhaXe, String tenNhaXe, int tongTien) {
        super();
        this.maNhaXe = maNhaXe;
        this.tenNhaXe = tenNhaXe;
        this.tongTien = tongTien;
    }
    public String getMaNhaXe() {
        return maNhaXe;
    }
    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }
    public String getTenNhaXe() {
        return tenNhaXe;
    }
    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }
    public int getTongTien() {
        return tongTien;
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
}
