package model;

public class XeMay extends Xe{
    private String bienSoXe;

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    @Override
    public String getLoaiXe() {
        return "2";
    }

    @Override
    public String getThongTinXe() {
        return String.format("%s;%s;%s", 2,getBienSoXe(),"Not Available");
    }
    public String toString() {
        return String.format("%s;%s;Not Available%s;Not Available;%s;Not Available;%s",getLoaiXe(),getBienSoXe(),getThoiGianVaoBai(),getThoiGianRaBai(),getTienThueBai());
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
        long soTienGui = soNgay * 3000;
        return "" + soPhutGui;
    }
    public static void main(String[] args) {
        Xe xe = new XeMay();
    }
}
