package Bean;

import java.util.Date;

public class MayTinhBean {
    private String ma;
    private String ten;
    private Long gia;
    private Long soLuong;
    private Date ngaySanXuat;
    private String maHang;
    public MayTinhBean() {  }
    public MayTinhBean(String ma, String ten, Long gia, Long soLuong,
            Date ngaySanXuat, String maHang) {
        super();
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.maHang = maHang;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public Long getGia() {
        return gia;
    }
    public void setGia(Long gia) {
        this.gia = gia;
    }
    public Long getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }
    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }
    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    
    
}
