package bean;

public class HoKhauBEAN {
    private String hoKhauID;
    private String tinh_TP;
   private String quan_Huyen;
   private String phuong_Xa;
   private String to_Thon;
   private String chuHoID;
   private String ten;
   
public HoKhauBEAN() {}

public HoKhauBEAN(String hoKhauID, String tinh_TP, String quan_Huyen,
        String phuong_Xa, String to_Thon, String chuHoID, String ten) {
    super();
    this.hoKhauID = hoKhauID;
    this.tinh_TP = tinh_TP;
    this.quan_Huyen = quan_Huyen;
    this.phuong_Xa = phuong_Xa;
    this.to_Thon = to_Thon;
    this.chuHoID = chuHoID;
    this.ten = ten;
}

public String getHoKhauID() {
    return hoKhauID;
}
public void setHoKhauID(String hoKhauID) {
    this.hoKhauID = hoKhauID;
}
public String getTinh_TP() {
    return tinh_TP;
}
public void setTinh_TP(String tinh_TP) {
    this.tinh_TP = tinh_TP;
}
public String getQuan_Huyen() {
    return quan_Huyen;
}
public void setQuan_Huyen(String quan_Huyen) {
    this.quan_Huyen = quan_Huyen;
}
public String getPhuong_Xa() {
    return phuong_Xa;
}
public void setPhuong_Xa(String phuong_Xa) {
    this.phuong_Xa = phuong_Xa;
}
public String getTo_Thon() {
    return to_Thon;
}
public void setTo_Thon(String to_Thon) {
    this.to_Thon = to_Thon;
}
public String getChuHoID() {
    return chuHoID;
}
public void setChuHoID(String chuHoID) {
    this.chuHoID = chuHoID;
}

public String getTen() {
    return ten;
}

public void setTen(String ten) {
    this.ten = ten;
}
   
   
}
