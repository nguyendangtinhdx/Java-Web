package com.tinhnd.day1;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
* Cau10.Chương trình đọc một file đầu vào có định dạng *.csv:
        Nội dung của file csv lưu thông tin của một nhóm sinh viên, bao gồm các thông tin sau: StdNo, StdName, StdPhone, StdEmail, GradePoint.
        a.  Hãy viết function đọc file csv, sau đó hiển thị toàn bộ thông tin của các sinh viên lên màn hình console.
        b.  Viết hàm kiểm tra dữ liệu của file csv, nếu sai định dạng phone hoặc email thì thông báo lỗi ra file error.txt.
 * 
 * Version 1.0
 * 
 * Date 14-1-2018
 * 
 * Copyright
 * 
 * Modification logs
 * DATE             AUTHOR              DESCRIPTION
 * ------------------------------------------------
 * 14-1-2018        TỉnhND               Create
 *
 */
public class Cau10 {

    /**
     *   main
     *   @param args
     *   @return 
     *   @throws  IOException
     */
    public static void main(String[] args) throws IOException {
        
        String[][] mangChuaFile = DocFile();
        XuatMang2Chieu(mangChuaFile);
        WriteToFileError(KiemTraTinhHopLe(mangChuaFile));
    }
    /**
     *   Hàm đọc file
     *   @param 
     *   @return 
     *   @throws IOException    
     */
    private static final String FILEREAD = "src/STD.csv";
    private static final String FILEWRITE = "src/error.txt";
    @SuppressWarnings("resource")
    private static String[][] DocFile() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(FILEREAD));
        String line = "";
        String cvsSplitBy = ",";
        int soDong = 0;
        try {
            
            while (br.readLine() != null) {
                soDong++;
            }
            
        }catch(FileNotFoundException e) {
            return null;
        }
        String[][] array = new String[soDong][5];
        
        try {
            
            int i = 0;
            br = null;
            br = new BufferedReader(new FileReader(FILEREAD));
            while ((line = br.readLine()) != null) {

                array[i] = line.split(cvsSplitBy);
                i++;
            }
            return array;

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    return null;
                }
            }
        }
        
    }

    /**
     *   Hàm chuyển chuổi sang mảng
     *   @param st
     *   @return charArray
     *   @throws     
     */
    private static char[] ChuyenChuoiSangMang(String st) {
        char[] charArray = st.toCharArray();
        return charArray;
    }
    
    /**
     *   Hàm  in mảng 2 chiều
     *   @param a
     *   @return 
     *   @throws     
     */
    private static void XuatMang2Chieu(String[][] a) {
        int tongSoDong = a.length;
        for(int chiSoDong = 0;chiSoDong < tongSoDong; chiSoDong++) {
            int tongSoCot = a[chiSoDong].length;
            for(int chiSoCot = 0; chiSoCot < tongSoCot; chiSoCot++)
                System.out.print(a[chiSoDong][chiSoCot] + ",");
            System.out.println();
        }
    }

    
    /**
     *   Hàm kiểm tra số điện thoại của 1 chuỗi
     *   @param st
     *   @return kt
     *   @throws     
     */
    private static boolean KiemTraSoDienThoaiCua1Chuoi(String st) {
        boolean kt = true;
        char[] charArray = ChuyenChuoiSangMang(st);
        for(int chiSoMang = 0; chiSoMang < charArray.length; chiSoMang++) {
            if(charArray[chiSoMang] <  48 || charArray[chiSoMang] > 57)
                kt = false;
        }
        
        return kt;
    }

    /**
     *   Hàm kiểm tra kí tự là kí tự số hoặc kí tự chữ
     *   @param kiTuTruoc, kiTuSau
     *   @return kt
     *   @throws     
     */
    private static boolean KiemTraKiTuLaSoHoacChu(char kiTuTruoc, char kiTuSau) {
        boolean kt = true;
        if((kiTuSau < 48 || (kiTuSau > 57 && kiTuSau < 'A') || (kiTuSau > 'Z' &&
                kiTuSau < 'a') || kiTuSau > 'z') || (kiTuTruoc < 48 || (kiTuTruoc > 57 && kiTuTruoc < 'A') 
                        || (kiTuTruoc > 'Z' && kiTuTruoc < 'a') || kiTuTruoc > 'z'))
            kt = false;
        
        return kt;
    }

    /**
     *   Hàm kiểm tra email
     *   @param st
     *   @return kt
     *   @throws     
     */
    private static boolean KiemTraEmail(String st) {
        boolean kt = true;
        int demDauCham = 0;
        int demDauAcong = 0;
        char dauCham = '.';
        char dauACong = '@';
        char[] charArray = ChuyenChuoiSangMang(st);
        int DoDaiCuaChuoi = charArray.length;
        if(charArray[0] == '.' || charArray[0] == '@')
            kt = false;
        if(charArray[charArray.length - 1] == '.' || charArray[charArray.length - 1] == '@')
            kt = false;
        for(int chiSoMang = 1; chiSoMang < DoDaiCuaChuoi; chiSoMang++) {
            if(charArray[chiSoMang] == dauCham) {
                if(KiemTraKiTuLaSoHoacChu(charArray[chiSoMang-1], charArray[chiSoMang + 1]) == false) {
                    kt = false;
                    break;
                }
                demDauCham++;
            }
            if(charArray[chiSoMang] == dauACong) {
                if(KiemTraKiTuLaSoHoacChu(charArray[chiSoMang-1], charArray[chiSoMang + 1]) == false) {
                    kt = false;
                    break;
                }
                demDauAcong++;
            }
        }
        if(demDauCham == 0)
            kt = false;
        if(demDauAcong != 1)
            kt = false;
        return kt;
    }
    
    /**
     *   Hàm kiểm tra tính hợp lệ
     *   @param a
     *   @return chuoiError
     *   @throws     
     */
    @SuppressWarnings("null")
    private static String KiemTraTinhHopLe(String[][] a) {
        String chuoiError = new String();
        for(int chiSoDong = 0; chiSoDong < a.length; chiSoDong++) {
            if(KiemTraSoDienThoaiCua1Chuoi(a[chiSoDong][2]) == false && KiemTraEmail(a[chiSoDong][3]) == false)
                chuoiError += "Line " + (chiSoDong + 1) + ": co loi sai dinh dang StdPhone, StdEmail.\r\n";
            else if(KiemTraSoDienThoaiCua1Chuoi(a[chiSoDong][2]) == false)
                chuoiError += "Line " + (chiSoDong + 1) + ": co loi sai dinh dang StdPhone.\r\n";
            else if(KiemTraEmail(a[chiSoDong][3]) == false)
                chuoiError = "Line " + (chiSoDong + 1) + ": co loi sai dinh dang StdEmail.\r\n";
            else
                continue;
        }
        return chuoiError;
                
    }
    /*
     * hàm ghi ra file lỗi
     */
    
    /**
     *   Hàm ghi ra file lỗi
     *   @param chuoiError
     *   @return 
     *   @throws     
     */
    private static void WriteToFileError(String chuoiError) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {


            fw = new FileWriter(FILEWRITE);
            bw = new BufferedWriter(fw);
            bw.write(chuoiError);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
    


}
