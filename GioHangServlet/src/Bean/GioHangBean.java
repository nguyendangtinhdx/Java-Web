package Bean;

public class GioHangBean {
    private String mahang;
    private String tenhang;
    private Long gia;
    private Long soluong;
    public GioHangBean(String mahang, String tenhang, Long gia, Long soluong) {
        super();
        this.mahang = mahang;
        this.tenhang = tenhang;
        this.gia = gia;
        this.soluong = soluong;
    }
    public String getMahang() {
        return mahang;
    }
    public void setMahang(String mahang) {
        this.mahang = mahang;
    }
    public String getTenhang() {
        return tenhang;
    }
    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }
    public Long getGia() {
        return gia;
    }
    public void setGia(Long gia) {
        this.gia = gia;
    }
    public Long getSoluong() {
        return soluong;
    }
    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }
    
}
