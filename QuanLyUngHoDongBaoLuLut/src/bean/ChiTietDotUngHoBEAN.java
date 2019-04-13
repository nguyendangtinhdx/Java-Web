package bean;

public class ChiTietDotUngHoBEAN {
    private String maDotUngHo;
    private String hinhThucUngHo;
    private Long soLuongUngHo;
    private String donViTinh;
    public ChiTietDotUngHoBEAN() { }
    public ChiTietDotUngHoBEAN(String maDotUngHo, String hinhThucUngHo,
            Long soLuongUngHo, String donViTinh) {
        super();
        this.maDotUngHo = maDotUngHo;
        this.hinhThucUngHo = hinhThucUngHo;
        this.soLuongUngHo = soLuongUngHo;
        this.donViTinh = donViTinh;
    }
    public String getMaDotUngHo() {
        return maDotUngHo;
    }
    public void setMaDotUngHo(String maDotUngHo) {
        this.maDotUngHo = maDotUngHo;
    }
    public String getHinhThucUngHo() {
        return hinhThucUngHo;
    }
    public void setHinhThucUngHo(String hinhThucUngHo) {
        this.hinhThucUngHo = hinhThucUngHo;
    }
    public Long getSoLuongUngHo() {
        return soLuongUngHo;
    }
    public void setSoLuongUngHo(Long soLuongUngHo) {
        this.soLuongUngHo = soLuongUngHo;
    }
    public String getDonViTinh() {
        return donViTinh;
    }
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    
}
