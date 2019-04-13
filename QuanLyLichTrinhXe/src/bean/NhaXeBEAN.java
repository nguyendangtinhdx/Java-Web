package bean;
/**
 * NhaXeBEAN
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
public class NhaXeBEAN {
    private String maNhaXe;
    private String tenNhaXe;
    private int namThanhLap;
    public NhaXeBEAN() {    }
    public NhaXeBEAN(String maNhaXe, String tenNhaXe, int namThanhLap) {
        super();
        this.maNhaXe = maNhaXe;
        this.tenNhaXe = tenNhaXe;
        this.namThanhLap = namThanhLap;
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
    public int getNamThanhLap() {
        return namThanhLap;
    }
    public void setNamThanhLap(int namThanhLap) {
        this.namThanhLap = namThanhLap;
    }
    
}
