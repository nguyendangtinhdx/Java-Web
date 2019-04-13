package model;

public class XeOto extends Xe{
    private String bienSoXe;
    private String tinhTrangLucVao;
    private String tinhTrangLucRa;
    public String getBienSoXe() {
        return bienSoXe;
    }
    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }
    public String getTinhTrangLucVao() {
        return tinhTrangLucVao;
    }
    public void setTinhTrangLucVao(String tinhTrangLucVao) {
        this.tinhTrangLucVao = tinhTrangLucVao;
    }
    public String getTinhTrangLucRa() {
        return tinhTrangLucRa;
    }
    public void setTinhTrangLucRa(String tinhTrangLucRa) {
        this.tinhTrangLucRa = tinhTrangLucRa;
    }
    @Override
    public String getLoaiXe() {
        return "4";
    }
    @Override
    public String getThongTinXe() {
        return String.format("%s;%s;%s", 4,getBienSoXe(),"Not Available");
    }
    public String toString() {
        return String.format("%s;%s;Not Available%s;%s;%s;%s;%s",getLoaiXe(),getBienSoXe(),getThoiGianVaoBai(),getTinhTrangLucVao(),getThoiGianRaBai(),getTinhTrangLucRa(),getTienThueBai());
    }
    @Override
    public String getTienThueBai() {
        if(getThoiGianRaBai() == null)
            return "Not Available";
        if(getTinhTrangLucRa().equals(getTinhTrangLucVao()) == false)
            return "Chưa xác định đang xử lý bồi thường"; 
        //1. tính thời gian chênh lệch giữa lúc vào bãi và ra bãi
        long thoiDiemRa = getThoiGianRaBai().getTime();
        long thoiDiemVao = getThoiGianVaoBai().getTime();
        long soPhutGui = (thoiDiemRa - thoiDiemVao)/60000;
        
        //2. chia ra số ngày chênh lệch
        long soNuaGio = soPhutGui / (30);
        long soPhutLe = soPhutGui % (30);
        if(soPhutLe != 0) {
            soNuaGio++;
        }
        
        //3. tính tiền
        long soTienGui = soNuaGio * 5000;
        return "" + soPhutGui;
    }
}
