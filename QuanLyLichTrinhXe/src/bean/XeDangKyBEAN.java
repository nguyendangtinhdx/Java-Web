package bean;
/**
 * XeDangKyBEAN
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

import java.util.Date;

public class XeDangKyBEAN {
    private String maXe;
    private String bienSo;
    private String tenTaiXe;
    private String tenNhaXe;
    private String maTuyen;
    private String tenTuyen;
    private Date ngayXuatBen;
    private String gioXuatBen;
    
    public XeDangKyBEAN() {    }
    
    public XeDangKyBEAN(String maXe, String bienSo, String tenTaiXe,
            String tenNhaXe, String maTuyen, String tenTuyen, Date ngayXuatBen,
            String gioXuatBen) {
        super();
        this.maXe = maXe;
        this.bienSo = bienSo;
        this.tenTaiXe = tenTaiXe;
        this.tenNhaXe = tenNhaXe;
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.ngayXuatBen = ngayXuatBen;
        this.gioXuatBen = gioXuatBen;
    }
    public String getMaXe() {
        return maXe;
    }
    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }
    public String getBienSo() {
        return bienSo;
    }
    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
    public String getTenTaiXe() {
        return tenTaiXe;
    }
    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }
    public String getTenNhaXe() {
        return tenNhaXe;
    }
    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }
    public String getMaTuyen() {
        return maTuyen;
    }
    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }
    public String getTenTuyen() {
        return tenTuyen;
    }
    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }
    public Date getNgayXuatBen() {
        return ngayXuatBen;
    }
    public void setNgayXuatBen(Date ngayXuatBen) {
        this.ngayXuatBen = ngayXuatBen;
    }
    public String getGioXuatBen() {
        return gioXuatBen;
    }
    public void setGioXuatBen(String gioXuatBen) {
        this.gioXuatBen = gioXuatBen;
    }
    
}
