package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class App {
    // câu 2
    private static List<Xe> docThongTinVaoBai(String filename){
        List<Xe> lstXe = new ArrayList<Xe>();
        
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            while(true) {
                String line = br.readLine();
                if(line == null)
                    break;
             // loại xe, biển số xe, số vé xe, thời gian vào bãi, trình trạng lúc vào
                String[] info = line.split(";");
                String loaiXe = info[0];
                String bienSoXe = info[1];
                String soVeXe = info[2];
                String stThoiGianVaoBai = info[3];
                String tinhTrangXeLucVao = info[4];
                Timestamp thoiGianVaoBai = null;
                try {
                    thoiGianVaoBai =  Utils.parseFromString(stThoiGianVaoBai);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if("0".equals(loaiXe)) {
                    XeDap x = new XeDap();
                    x.setSoVeXe(soVeXe);
                    x.setThoiGianVaoBai(thoiGianVaoBai);
                    lstXe.add(x);
                }else  if("2".equals(loaiXe)) {
                    XeMay x = new XeMay();
                    x.setBienSoXe(bienSoXe);
                    x.setThoiGianVaoBai(thoiGianVaoBai);
                    lstXe.add(x);
                }else  if("4".equals(loaiXe)) {
                    XeOto x = new XeOto();
                    x.setBienSoXe(bienSoXe);
                    x.setThoiGianVaoBai(thoiGianVaoBai);
                    x.setTinhTrangLucVao(tinhTrangXeLucVao);
                    lstXe.add(x);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fr !=null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        // in thông tin
        System.out.println("Thông tin xe lúc vào bãi");
        for(Xe x : lstXe)
            System.out.println(x.toString());
        
        return lstXe;
    }
    // câu 4
    private static void luuVaoCSDL(List<Xe> lstXe) {
        for(Xe x : lstXe) {
            try {
                DbUtils.insertThongTinVaoBai(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * cập nhật thông tin ra bãi của các xe có trong danh sách tương ứng
     * @param filename
     * @param lstXe
     */
    private static void docThongTinRaBai(String filename, List<Xe> lstXe) {
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            while(true) {
                String line = br.readLine();
                if(line == null)
                    break;
             // loại xe, biển số xe, số vé xe, thời gian ra bãi, trình trạng lúc vào
                // xe lúc ra bãi
                String[] info = line.split(";");
                String loaiXe = info[0];
                String bienSoXe = info[1];
                String soVeXe = info[2];
                String stThoiGianRaBai = info[3];
                String tinhTrangXeLucRa = info[4];
                Timestamp thoiGianRaBai = null;
                try {
                    thoiGianRaBai =  Utils.parseFromString(stThoiGianRaBai);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String thongTinXe = String.format("%s;%s;%s", loaiXe,bienSoXe,soVeXe);
                // cập nhật thông tiin này cho đối tượng phù hợp trong lstXe
                for(Xe x : lstXe) {
                    if(x.getThongTinXe().equals(thongTinXe)){
                        x.setThoiGianRaBai(thoiGianRaBai);
                        if (x instanceof XeOto) {
                            XeOto x4 = (XeOto)x;
                            x4.setTinhTrangLucRa(tinhTrangXeLucRa);
                        }
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fr !=null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        // in thông tin
        System.out.println("Thông tin xe lúc ra bãi");
        for(Xe x : lstXe)
            System.out.println(x.toString());
    }
    
    public static void main(String[] args) {
        // câu 2
        List<Xe> lst =  docThongTinVaoBai("E:\\input1.txt");
        // câu 4
   //     luuVaoCSDL(lst);
        // câu 5
        docThongTinRaBai("E:\\input2.txt", lst);
        // câu 6
        frmThongKe f = new frmThongKe(lst);
        f.setVisible(true);
    }

}
