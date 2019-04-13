package model;

public class DonHang {
    String maDonHang;
    String tenTaiKhoan;
    String danhSachMaSanPham;
    String danhSachTenSanPham;
    String tongSoLuong;
    String tongTien;
    String  ngayMua;
    String diaChi;
    String soDienThoai;
    String email;
    String tinhTrangDonHang;
    public DonHang(String maDonHang, String tenTaiKhoan,
            String danhSachMaSanPham, String danhSachTenSanPham,
            String tongSoLuong, String tongTien, String ngayMua, String diaChi,
            String soDienThoai, String email, String tinhTrangDonHang) {
        super();
        this.maDonHang = maDonHang;
        this.tenTaiKhoan = tenTaiKhoan;
        this.danhSachMaSanPham = danhSachMaSanPham;
        this.danhSachTenSanPham = danhSachTenSanPham;
        this.tongSoLuong = tongSoLuong;
        this.tongTien = tongTien;
        this.ngayMua = ngayMua;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.tinhTrangDonHang = tinhTrangDonHang;
    }
    public String getMaDonHang() {
        return maDonHang;
    }
    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }
    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }
    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }
    public String getDanhSachMaSanPham() {
        return danhSachMaSanPham;
    }
    public void setDanhSachMaSanPham(String danhSachMaSanPham) {
        this.danhSachMaSanPham = danhSachMaSanPham;
    }
    public String getDanhSachTenSanPham() {
        return danhSachTenSanPham;
    }
    public void setDanhSachTenSanPham(String danhSachTenSanPham) {
        this.danhSachTenSanPham = danhSachTenSanPham;
    }
    public String getTongSoLuong() {
        return tongSoLuong;
    }
    public void setTongSoLuong(String tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }
    public String getTongTien() {
        return tongTien;
    }
    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
    public String getNgayMua() {
        return ngayMua;
    }
    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTinhTrangDonHang() {
        return tinhTrangDonHang;
    }
    public void setTinhTrangDonHang(String tinhTrangDonHang) {
        this.tinhTrangDonHang = tinhTrangDonHang;
    }
    @Override
    public String toString() {
        return "DonHang [maDonHang=" + maDonHang + ", tenTaiKhoan="
                + tenTaiKhoan + ", danhSachMaSanPham=" + danhSachMaSanPham
                + ", danhSachTenSanPham=" + danhSachTenSanPham
                + ", tongSoLuong=" + tongSoLuong + ", tongTien=" + tongTien
                + ", ngayMua=" + ngayMua + ", diaChi=" + diaChi
                + ", soDienThoai=" + soDienThoai + ", email=" + email
                + ", tinhTrangDonHang=" + tinhTrangDonHang + "]";
    }
    
}
