package model;

public class SanPham {
    String maSanPham;
    String tenSanPham;
    String giaDaGiam;
    String giaBan;
    String soLuong;
    String nhaCungCap;
    String maLoai;
    String hinhAnh;
    String  soLuongNhap;
    String soLuongBan;
    public SanPham(String maSanPham, String tenSanPham, String giaDaGiam,
            String giaBan, String soLuong, String nhaCungCap, String maLoai,
            String hinhAnh, String soLuongNhap, String soLuongBan) {
        super();
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaDaGiam = giaDaGiam;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaCungCap = nhaCungCap;
        this.maLoai = maLoai;
        this.hinhAnh = hinhAnh;
        this.soLuongNhap = soLuongNhap;
        this.soLuongBan = soLuongBan;
    }
    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    public String getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    public String getGiaDaGiam() {
        return giaDaGiam;
    }
    public void setGiaDaGiam(String giaDaGiam) {
        this.giaDaGiam = giaDaGiam;
    }
    public String getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }
    public String getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }
    public String getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public String getMaLoai() {
        return maLoai;
    }
    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public String getSoLuongNhap() {
        return soLuongNhap;
    }
    public void setSoLuongNhap(String soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
    public String getSoLuongBan() {
        return soLuongBan;
    }
    public void setSoLuongBan(String soLuongBan) {
        this.soLuongBan = soLuongBan;
    }
    @Override
    public String toString() {
        return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham
                + ", giaDaGiam=" + giaDaGiam + ", giaBan=" + giaBan
                + ", soLuong=" + soLuong + ", nhaCungCap=" + nhaCungCap
                + ", maLoai=" + maLoai + ", hinhAnh=" + hinhAnh
                + ", soLuongNhap=" + soLuongNhap + ", soLuongBan=" + soLuongBan
                + "]";
    }
    
}
