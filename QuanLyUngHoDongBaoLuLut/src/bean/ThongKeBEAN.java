package bean;

public class ThongKeBEAN {
    private String maHoDan;
    private String hoTenChuHo;
    private Long to;
    private String khoiHoacThon;
    private String laHoNgheo;
    private double tongSoTienMat;
    public ThongKeBEAN() { }
    public ThongKeBEAN(String maHoDan, String hoTenChuHo, Long to,
            String khoiHoacThon, String laHoNgheo, double tongSoTienMat) {
        super();
        this.maHoDan = maHoDan;
        this.hoTenChuHo = hoTenChuHo;
        this.to = to;
        this.khoiHoacThon = khoiHoacThon;
        this.laHoNgheo = laHoNgheo;
        this.tongSoTienMat = tongSoTienMat;
    }
    public String getMaHoDan() {
        return maHoDan;
    }
    public void setMaHoDan(String maHoDan) {
        this.maHoDan = maHoDan;
    }
    public String getHoTenChuHo() {
        return hoTenChuHo;
    }
    public void setHoTenChuHo(String hoTenChuHo) {
        this.hoTenChuHo = hoTenChuHo;
    }
    public Long getTo() {
        return to;
    }
    public void setTo(Long to) {
        this.to = to;
    }
    public String getKhoiHoacThon() {
        return khoiHoacThon;
    }
    public void setKhoiHoacThon(String khoiHoacThon) {
        this.khoiHoacThon = khoiHoacThon;
    }
    public String getLaHoNgheo() {
        return laHoNgheo;
    }
    public void setLaHoNgheo(String laHoNgheo) {
        this.laHoNgheo = laHoNgheo;
    }
    public double getTongSoTienMat() {
        return tongSoTienMat;
    }
    public void setTongSoTienMat(double tongSoTienMat) {
        this.tongSoTienMat = tongSoTienMat;
    }
    
}
