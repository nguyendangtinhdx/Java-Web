package Bean;

import java.util.Date;

public class SachBean {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private Long soLuong;
    private Long gia;
    private String soTap;
    private String anh;
    private Date ngayNhap;
    private String maLoai;
    
    public SachBean() {}

    public SachBean(String maSach, String tenSach, String tacGia, Long soLuong,
            Long gia, String soTap, String anh, Date ngayNhap, String maLoai) {
        super();
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.gia = gia;
        this.soTap = soTap;
        this.anh = anh;
        this.ngayNhap = ngayNhap;
        this.maLoai = maLoai;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getSoTap() {
        return soTap;
    }

    public void setSoTap(String soTap) {
        this.soTap = soTap;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    
    
}
