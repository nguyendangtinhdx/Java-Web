package Bean;

public class HangBean {
    private String maHang;
    private String tenHang;
    public HangBean() { }
    public HangBean(String maHang, String tenHang) {
        super();
        this.maHang = maHang;
        this.tenHang = tenHang;
    }
    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
    
}
