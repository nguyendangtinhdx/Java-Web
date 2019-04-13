package model;

public class XeDap extends Xe {
    private String soVeXe;

    public String getSoVeXe() {
        return soVeXe;
    }

    public void setSoVeXe(String soVeXe) {
        this.soVeXe = soVeXe;
    }

    @Override
    public String getLoaiXe() {
        return "0";
    }

    @Override
    public String getThongTinXe() {
        return String.format("%s;%s;%s", 0,"Not Available",getSoVeXe());
    }
    public String toString() {
        return String.format("%s;Not Available;%s;%s;Not Available;%s;Not Available;%s",getLoaiXe(),getSoVeXe(),getThoiGianVaoBai(),getThoiGianRaBai(),getTienThueBai());
    }

    @Override
    public String getTienThueBai() {
        if(getThoiGianRaBai() == null)
            return "Not Available";
        //1. tính thời gian chênh lệch giữa lúc vào bãi và ra bãi
        long thoiDiemRa = getThoiGianRaBai().getTime();
        long thoiDiemVao = getThoiGianVaoBai().getTime();
        long soPhutGui = (thoiDiemRa - thoiDiemVao)/60000;
        
        //2. chia ra số ngày chênh lệch
        long soNgay = soPhutGui / (24 * 60);
        long soPhutLe = soPhutGui % (24 * 60);
        if(soPhutLe != 0) {
            soNgay++;
        }
        
        //3. tính tiền
        long soTienGui = soNgay * 1000;
        return "" + soPhutGui;
    }
    
}
