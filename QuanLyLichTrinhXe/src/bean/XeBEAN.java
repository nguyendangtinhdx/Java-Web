package bean;

import java.util.Date;

/**
 * XeBEAN
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
public class XeBEAN {
    private String maXe;
    private String hangSanXuat;
    private String maLoaiXe;
    private String bienSo;
    private Date hanKiemDinh;
    private String maNhaXe;
    public XeBEAN() {    }
    public XeBEAN(String maXe, String hangSanXuat, String maLoaiXe,
            String bienSo, Date hanKiemDinh, String maNhaXe) {
        super();
        this.maXe = maXe;
        this.hangSanXuat = hangSanXuat;
        this.maLoaiXe = maLoaiXe;
        this.bienSo = bienSo;
        this.hanKiemDinh = hanKiemDinh;
        this.maNhaXe = maNhaXe;
    }
    public String getMaXe() {
        return maXe;
    }
    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }
    public String getHangSanXuat() {
        return hangSanXuat;
    }
    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public String getMaLoaiXe() {
        return maLoaiXe;
    }
    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }
    public String getBienSo() {
        return bienSo;
    }
    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
    public Date getHanKiemDinh() {
        return hanKiemDinh;
    }
    public void setHanKiemDinh(Date hanKiemDinh) {
        this.hanKiemDinh = hanKiemDinh;
    }
    public String getMaNhaXe() {
        return maNhaXe;
    }
    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }
    
    
}
