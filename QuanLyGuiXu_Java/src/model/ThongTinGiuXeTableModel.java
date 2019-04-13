package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ThongTinGiuXeTableModel  extends AbstractTableModel{
    private String[] ColNames= {"Loại xe", "Biển số xe", "Số vé", "Thời gian vào bãi", "Thời gian ra bãu", "Tiền thuê bãi"};
    private List<Xe> lstXe;
    
    public List<Xe> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<Xe> lstXe) {
        this.lstXe = lstXe;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        if(getLstXe() == null)
            return 0;
        return getLstXe().size();
    }
    public String getColumnName(int column) {
        return ColNames[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Xe x = getLstXe().get(rowIndex);
        XeDap x0 = null;
        XeMay x2 = null;
        XeOto x4 = null;
        if(x instanceof XeDap)
            x0 = (XeDap)x;
        else if(x instanceof XeMay)
            x2 = (XeMay)x;
        else
            x4 = (XeOto)x;
        
        switch (columnIndex) {
            case 0:
                return x.getLoaiXe();
            case 1: 
                if(x instanceof XeDap)
                    return "Not Available";
                else if (x instanceof XeMay)
                    return x2.getBienSoXe();
                else
                    return x4.getBienSoXe();
            case 2:
                if(x instanceof XeDap)
                    return x0.getSoVeXe();
                else if (x instanceof XeMay)
                    return "Not Available";
                else
                    return "Not Available";
            case 3:
                return DbUtils.getStringOf(x.getThoiGianVaoBai());
            case 4:
                if(x.getThoiGianRaBai() == null)
                    return "Not Available";
                else
                return DbUtils.getStringOf(x.getThoiGianRaBai());
            default:
                return x.getTienThueBai();
              
        }
    }

}
