package model;

import java.sql.Timestamp;

public abstract class Xe {
    private Timestamp thoiGianVaoBai;
    private Timestamp thoiGianRaBai;
    public Timestamp getThoiGianVaoBai() {
        return thoiGianVaoBai;
    }
    public void setThoiGianVaoBai(Timestamp thoiGianVaoBai) {
        this.thoiGianVaoBai = thoiGianVaoBai;
    }
    public Timestamp getThoiGianRaBai() {
        return thoiGianRaBai;
    }
    public void setThoiGianRaBai(Timestamp thoiGianRaBai) {
        this.thoiGianRaBai = thoiGianRaBai;
    }
    abstract public String getLoaiXe() ;
    abstract public String getThongTinXe();
    
    abstract public String getTienThueBai();
    
}
