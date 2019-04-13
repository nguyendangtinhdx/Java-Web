package com.tinhnd.day2day3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Main
 * 
 * Version 1.0
 * 
 * Date 16-1-2018
 * 
 * Copyright
 * 
 * Modification logs
 * DATE             AUTHOR              DESCRIPTION
 * ------------------------------------------------
 * 16-1-2018        TỉnhND               Create
 *
 */
public class Main {
    ArrayList<Candidate> candidate = new ArrayList<Candidate>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   
    int loaiUngVien;
    int expInYear;
    int IsContinue;
    int count = 0;
    String proSkill = "";
    Scanner sc = new Scanner(System.in);
    
    Date dateExp = null;
    Date dateCert = null;
    
    String candidateID = "";
    String fullName = "";
    String birthDay = "";
    String phone = "";
    String email = "";
    
    String certificatedID = "";
    String certificateName = "";
    String certificateRank = "";
    String certificatedDate = "";
    
    /**
     *   main
     *   @param args
     *   @return
     *   @throws     
     */
    public static void main(String[] args) {
        Main main = new Main();
         main.nhapLoaiUngVien();
    }
    /**
     *   Hàm nhập loại ứng viên
     *   @param 
     *   @return 
     *   @throws     
     */
    void nhapLoaiUngVien() {
        
        System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern");
        loaiUngVien = sc.nextInt();
        do {
            ++count;
            switch (loaiUngVien) {
            case 0:
                    nhapUngVien();
                    System.out.println("ExpInYear: ");
                    expInYear = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.println("ProSkill: ");
                    proSkill = sc.nextLine();
                    
                    nhapChungChi();
                    
                    Certificate certificate = new Certificate(certificatedID, certificateName, certificateRank, sdf.format(dateCert));
                    Experience experience = new Experience(candidateID, fullName, sdf.format(dateExp), phone, email,candidate.size()+1, expInYear, proSkill,certificate);
                    candidate.add(experience);
                    inUngVien();
                    do {
                        System.out.println("Bạn có muốn nhập tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                        IsContinue = sc.nextInt();
                    }while (IsContinue != 0 && IsContinue != 1);
                    if(IsContinue == 0)
                        break;
                    System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern");
                    
                break;
    
            default:
                break;
            }
        }while(IsContinue == 1);
        
    }

    /**
     *   Hàm nhập ứng viên
     *   @param 
     *   @return 
     *   @throws     
     */
    void nhapUngVien()
    {
        sc = new Scanner(System.in);
        System.out.println("CandidateID: ");
        candidateID = sc.nextLine();
        System.out.println("FullName: ");
        fullName = sc.nextLine();
        System.out.println("BirthDay: ");
        birthDay = sc.nextLine();
        
        if(kiemTraNgaySinh(birthDay) == false) {
            System.out.println("Sai định dạng ngày: ");
            System.out.println("BirthDay: ");
            birthDay = sc.nextLine();
        }
//        try {
//            dateExp = sdf.parse(birthDay);
//        } catch (ParseException e) {
//        }
        System.out.println("Phone: ");
        phone = sc.nextLine();
        if(kiemTraSDT(phone) == false) {
            System.out.println("Số điện thoại không hợp lệ ");
            System.out.println("Phone: ");
            phone = sc.nextLine();
        }
        System.out.println("Email: ");
        email = sc.nextLine();
        if(kiemTraEmail(email) == false) {
            System.out.println("Email không hợp lệ ! ");
            System.out.println("Email: ");
            email = sc.nextLine();
        }
    }
    
    /**
     *   Hàm nhập chứng chỉ
     *   @param 
     *   @return 
     *   @throws     
     */
    void nhapChungChi() {
        System.out.println("CertificatedID: ");
        certificatedID = sc.nextLine();
        System.out.println("CertificateName: ");
        certificateName = sc.nextLine();
        System.out.println("CertificateRank: ");
        certificateRank = sc.nextLine();
        System.out.println("CertificatedDate: ");
        certificatedDate = sc.nextLine();
        try {
            dateCert = sdf.parse(certificatedDate);
        } catch (ParseException e) {
        }
    }
    /**
     *   Hàm ini ứng viên
     *   @param 
     *   @return 
     *   @throws     
     */
    void inUngVien() {
        System.out.println("Mã ứng viên; Họ tên; Ngày sinh; Số điện thoại; Email; Số năm kinh nghiệm; Kỹ năng chuyên môn; Mã chứng chỉ; Tên chứng chỉ; Xếp loại; Ngày chứng nhận; Loại ứng viên; Số lượng");
        for (Candidate cand : candidate) {
            ((Experience) cand).ShowMe();
            System.out.println(((Experience) cand).ShowMe());
        }
    }
    /**
     *   Hàm kiểm tra ngày sinh
     *   @param  birthDay
     *   @return 
     *   @throws     
     */
    private static boolean kiemTraNgaySinh(String birthDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateBirth = sdf.parse(birthDay);
            if  (dateBirth.getDate() > 31) {
                return false;
            }
            if  (dateBirth.getMonth() > 12) {
                return false;
            }
            if  (dateBirth.getYear() < 1900) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     *   Hàm kiểm tra số điện thoại
     *   @param  sdtPhone
     *   @return 
     *   @throws     
     */
    private static boolean kiemTraSDT(String sdtPhone) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(sdtPhone);
        if (!matcher.matches()) {
            return false;
        } else
        if (sdtPhone.length() == 9 || sdtPhone.length() == 10) {
            if (sdtPhone.length() == 9) {
                if (sdtPhone.substring(0, 1).equals("9")) {
                    return true;
                } else {
                    return false;
                }
            } else if (sdtPhone.substring(0, 1).equals("1")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     *   Hàm kiểm tra email
     *   @param  stdEmail
     *   @return 
     *   @throws     
     */
    private static boolean kiemTraEmail(String stdEmail) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(stdEmail);
        if(matcher.find()){
             return true;
        }else{
             return false;
        }
    }
}
