package bean;
/**
 * LoaiXeBEAN
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
public class LoaiXeBEAN {
    private String maLoaiXe;
    private String moTaLoaiXe;
    private int soLuongChoNgoi;
    public LoaiXeBEAN() {    }
    public LoaiXeBEAN(String maLoaiXe, String moTaLoaiXe, int soLuongChoNgoi) {
        super();
        this.maLoaiXe = maLoaiXe;
        this.moTaLoaiXe = moTaLoaiXe;
        this.soLuongChoNgoi = soLuongChoNgoi;
    }
    public String getMaLoaiXe() {
        return maLoaiXe;
    }
    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }
    public String getMoTaLoaiXe() {
        return moTaLoaiXe;
    }
    public void setMoTaLoaiXe(String moTaLoaiXe) {
        this.moTaLoaiXe = moTaLoaiXe;
    }
    public int getSoLuongChoNgoi() {
        return soLuongChoNgoi;
    }
    public void setSoLuongChoNgoi(int soLuongChoNgoi) {
        this.soLuongChoNgoi = soLuongChoNgoi;
    };
    
}
