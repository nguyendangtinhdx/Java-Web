package bean;

import java.util.Date;
/**
 * LichTrinhXeBEAN
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
public class LichTrinhXeBEAN {
    private String maXe;
    private String tenTaiXe;
    private String maTuyen;
    private Date ngayXuatBen;
    private String gioXuatBen;
    private int soLuongHanhKhach;
    public LichTrinhXeBEAN(){    }
    public LichTrinhXeBEAN(String maXe, String tenTaiXe, String maTuyen,
            Date ngayXuatBen, String gioXuatBen, int soLuongHanhKhach) {
        super();
        this.maXe = maXe;
        this.tenTaiXe = tenTaiXe;
        this.maTuyen = maTuyen;
        this.ngayXuatBen = ngayXuatBen;
        this.gioXuatBen = gioXuatBen;
        this.soLuongHanhKhach = soLuongHanhKhach;
    }
    public String getMaXe() {
        return maXe;
    }
    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }
    public String getTenTaiXe() {
        return tenTaiXe;
    }
    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }
    public String getMaTuyen() {
        return maTuyen;
    }
    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
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
    public int getSoLuongHanhKhach() {
        return soLuongHanhKhach;
    }
    public void setSoLuongHanhKhach(int soLuongHanhKhach) {
        this.soLuongHanhKhach = soLuongHanhKhach;
    }
    
    
}
