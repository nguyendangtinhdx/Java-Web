package Bean;

public class HangBean {
    private String mahnag;
    private String tenhang;
    private Long soluong;
    private Long gia;
    private Long thanhtien;
    private String anh;
    public HangBean(String mahnag, String tenhang, Long soluong, Long gia, String anh) {
        super();
        this.mahnag = mahnag;
        this.tenhang = tenhang;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = gia * soluong;
        this.anh = anh;
    }
    public String getMahnag() {
        return mahnag;
    }
    public void setMahnag(String mahnag) {
        this.mahnag = mahnag;
    }
    public String getTenhang() {
        return tenhang;
    }
    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }
    public Long getSoluong() {
        return soluong;
    }
    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }
    public Long getGia() {
        return gia;
    }
    public void setGia(Long gia) {
        this.gia = gia;
    }
    public Long getThanhtien() {
        return thanhtien;
    }
    public void setThanhtien(Long thanhtien) {
        this.thanhtien = thanhtien;
    }
    public String getAnh() {
        return anh;
    }
    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
