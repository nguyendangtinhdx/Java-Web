package Bean;

public class KhachHangBean {
    private Long maKhachHang;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String email;
    private String tenDangNhap;
    private String matKhau;
    
    public KhachHangBean() {
        super();
    }
    
    public KhachHangBean(Long maKhachHang, String hoTen, String diaChi,
            String sdt, String email, String tenDangNhap, String matKhau) {
        super();
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public Long getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
