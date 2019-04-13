package bean;

import java.util.Date;

public class LichSuLuuTruBEAN {
    private String cmndID;
    private String hoKhauID;
    private String loaiLuuTruID;
    private Date thoiGianBatDauLT;
    private Date thoiGianKetThucLT;
    private String quanHeVoiChuHo;
    public LichSuLuuTruBEAN() {   }
    public LichSuLuuTruBEAN(String cmndID, String hoKhauID, String loaiLuuTruID,
            Date thoiGianBatDauLT, Date thoiGianKetThucLT,
            String quanHeVoiChuHo) {
        super();
        this.cmndID = cmndID;
        this.hoKhauID = hoKhauID;
        this.loaiLuuTruID = loaiLuuTruID;
        this.thoiGianBatDauLT = thoiGianBatDauLT;
        this.thoiGianKetThucLT = thoiGianKetThucLT;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }
    public String getCmndID() {
        return cmndID;
    }
    public void setCmndID(String cmndID) {
        this.cmndID = cmndID;
    }
    public String getHoKhauID() {
        return hoKhauID;
    }
    public void setHoKhauID(String hoKhauID) {
        this.hoKhauID = hoKhauID;
    }
    public String getLoaiLuuTruID() {
        return loaiLuuTruID;
    }
    public void setLoaiLuuTruID(String loaiLuuTruID) {
        this.loaiLuuTruID = loaiLuuTruID;
    }
    public Date getThoiGianBatDauLT() {
        return thoiGianBatDauLT;
    }
    public void setThoiGianBatDauLT(Date thoiGianBatDauLT) {
        this.thoiGianBatDauLT = thoiGianBatDauLT;
    }
    public Date getThoiGianKetThucLT() {
        return thoiGianKetThucLT;
    }
    public void setThoiGianKetThucLT(Date thoiGianKetThucLT) {
        this.thoiGianKetThucLT = thoiGianKetThucLT;
    }
    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }
    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }
        
    
}
