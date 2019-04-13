package bean;
/**
 * TuyenXeBEAN
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
public class TuyenXeBEAN {
    private String maTuyenXe;
    private String tenTuyen;
    private int donGia;
    public TuyenXeBEAN() {    }
    public TuyenXeBEAN(String maTuyenXe, String tenTuyen, int donGia) {
        super();
        this.maTuyenXe = maTuyenXe;
        this.tenTuyen = tenTuyen;
        this.donGia = donGia;
    }
    public String getMaTuyenXe() {
        return maTuyenXe;
    }
    public void setMaTuyenXe(String maTuyenXe) {
        this.maTuyenXe = maTuyenXe;
    }
    public String getTenTuyen() {
        return tenTuyen;
    }
    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }
    public int getDonGia() {
        return donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
