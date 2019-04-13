package Bean;

public class GioHangBean {
    private String maHang;
    private String tenHang;
    private Long gia;
    private int soLuong;
    public GioHangBean(String maHang, String tenHang, Long gia, int soLuong) {
        super();
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.gia = gia;
        this.soLuong = soLuong;
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
    public Long getGia() {
        return gia;
    }
    public void setGia(Long gia) {
        this.gia = gia;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
   
}
