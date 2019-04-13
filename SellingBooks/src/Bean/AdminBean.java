package Bean;

public class AdminBean {
    private String tenDanhNhap;
    private String matKhau;
    private int quyen;
    public AdminBean() {}
    public AdminBean(String tenDanhNhap, String matKhau, int quyen) {
        super();
        this.tenDanhNhap = tenDanhNhap;
        this.matKhau = matKhau;
        this.quyen = quyen;
    }
    public String getTenDanhNhap() {
        return tenDanhNhap;
    }
    public void setTenDanhNhap(String tenDanhNhap) {
        this.tenDanhNhap = tenDanhNhap;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public int getQuyen() {
        return quyen;
    }
    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
   
    
}
