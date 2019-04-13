package bean;

import java.util.Date;

public class DotNhanUngHoBEAN {
    private String maDotNhanUngHo;
    private String maHoDan;
    private Date ngayNhanUngHo;
    private String hinhThucNhanUngHo;
    private Long soLuongNhanUngHo;
    public DotNhanUngHoBEAN() { }
    public DotNhanUngHoBEAN(String maDotNhanUngHo, String maHoDan,
            Date ngayNhanUngHo, String hinhThucNhanUngHo,
            Long soLuongNhanUngHo) {
        super();
        this.maDotNhanUngHo = maDotNhanUngHo;
        this.maHoDan = maHoDan;
        this.ngayNhanUngHo = ngayNhanUngHo;
        this.hinhThucNhanUngHo = hinhThucNhanUngHo;
        this.soLuongNhanUngHo = soLuongNhanUngHo;
    }
    public String getMaDotNhanUngHo() {
        return maDotNhanUngHo;
    }
    public void setMaDotNhanUngHo(String maDotNhanUngHo) {
        this.maDotNhanUngHo = maDotNhanUngHo;
    }
    public String getMaHoDan() {
        return maHoDan;
    }
    public void setMaHoDan(String maHoDan) {
        this.maHoDan = maHoDan;
    }
    public Date getNgayNhanUngHo() {
        return ngayNhanUngHo;
    }
    public void setNgayNhanUngHo(Date ngayNhanUngHo) {
        this.ngayNhanUngHo = ngayNhanUngHo;
    }
    public String getHinhThucNhanUngHo() {
        return hinhThucNhanUngHo;
    }
    public void setHinhThucNhanUngHo(String hinhThucNhanUngHo) {
        this.hinhThucNhanUngHo = hinhThucNhanUngHo;
    }
    public Long getSoLuongNhanUngHo() {
        return soLuongNhanUngHo;
    }
    public void setSoLuongNhanUngHo(Long soLuongNhanUngHo) {
        this.soLuongNhanUngHo = soLuongNhanUngHo;
    }
    
    
}
