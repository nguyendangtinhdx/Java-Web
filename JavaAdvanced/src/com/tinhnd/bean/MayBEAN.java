package com.tinhnd.bean;

public class MayBEAN {
    private String maMay;
    private String viTri;
    private String trangThai;
    public MayBEAN() {}
    public MayBEAN(String maMay, String viTri, String trangThai) {
        super();
        this.maMay = maMay;
        this.viTri = viTri;
        this.trangThai = trangThai;
    }
    public String getMaMay() {
        return maMay;
    }
    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }
    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
