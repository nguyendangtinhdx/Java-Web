package bean;

import java.util.Date;

public class HoatDongBEAN {
    private String maHoatDong;
    private String tenHoatDong;
    private String moTaHoatDong;
    private Date ngayGioBatDau;
    private Date ngayGioKetThuc;
    private Long soLuongToiThieu;
    private Long soLuongToiDa;
    private String thoiHanDangKy;
    private String trangThai;
    private String maThanhVien;
    private String lyDoHuyHoatDong;
    public HoatDongBEAN() {   }
    public HoatDongBEAN(String maHoatDong, String tenHoatDong,
            String moTaHoatDong, Date ngayGioBatDau, Date ngayGioKetThuc,
            Long soLuongToiThieu, Long soLuongToiDa, String thoiHanDangKy,
            String trangThai, String maThanhVien, String lyDoHuyHoatDong) {
        super();
        this.maHoatDong = maHoatDong;
        this.tenHoatDong = tenHoatDong;
        this.moTaHoatDong = moTaHoatDong;
        this.ngayGioBatDau = ngayGioBatDau;
        this.ngayGioKetThuc = ngayGioKetThuc;
        this.soLuongToiThieu = soLuongToiThieu;
        this.soLuongToiDa = soLuongToiDa;
        this.thoiHanDangKy = thoiHanDangKy;
        this.trangThai = trangThai;
        this.maThanhVien = maThanhVien;
        this.lyDoHuyHoatDong = lyDoHuyHoatDong;
    }
    public String getMaHoatDong() {
        return maHoatDong;
    }
    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }
    public String getTenHoatDong() {
        return tenHoatDong;
    }
    public void setTenHoatDong(String tenHoatDong) {
        this.tenHoatDong = tenHoatDong;
    }
    public String getMoTaHoatDong() {
        return moTaHoatDong;
    }
    public void setMoTaHoatDong(String moTaHoatDong) {
        this.moTaHoatDong = moTaHoatDong;
    }
    public Date getNgayGioBatDau() {
        return ngayGioBatDau;
    }
    public void setNgayGioBatDau(Date ngayGioBatDau) {
        this.ngayGioBatDau = ngayGioBatDau;
    }
    public Date getNgayGioKetThuc() {
        return ngayGioKetThuc;
    }
    public void setNgayGioKetThuc(Date ngayGioKetThuc) {
        this.ngayGioKetThuc = ngayGioKetThuc;
    }
    public Long getSoLuongToiThieu() {
        return soLuongToiThieu;
    }
    public void setSoLuongToiThieu(Long soLuongToiThieu) {
        this.soLuongToiThieu = soLuongToiThieu;
    }
    public Long getSoLuongToiDa() {
        return soLuongToiDa;
    }
    public void setSoLuongToiDa(Long soLuongToiDa) {
        this.soLuongToiDa = soLuongToiDa;
    }
    public String getThoiHanDangKy() {
        return thoiHanDangKy;
    }
    public void setThoiHanDangKy(String thoiHanDangKy) {
        this.thoiHanDangKy = thoiHanDangKy;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public String getMaThanhVien() {
        return maThanhVien;
    }
    public void setMaThanhVien(String maThanhVien) {
        this.maThanhVien = maThanhVien;
    }
    public String getLyDoHuyHoatDong() {
        return lyDoHuyHoatDong;
    }
    public void setLyDoHuyHoatDong(String lyDoHuyHoatDong) {
        this.lyDoHuyHoatDong = lyDoHuyHoatDong;
    }
   
    
    
    
}
