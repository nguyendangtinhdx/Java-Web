package com.tinhnd.day4day5.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.tinhnd.day4day5.bean.CandidateBEAN;
import com.tinhnd.day4day5.bean.CertificateBEAN;
import com.tinhnd.day4day5.bean.ExperienceBEAN;
import com.tinhnd.day4day5.bean.FresherBEAN;
import com.tinhnd.day4day5.bean.InternBEAN;
import com.tinhnd.day4day5.bo.CandidateBO;
import com.tinhnd.day4day5.bo.CertificateBO;
import com.tinhnd.day4day5.dao.CandidateDAO;
import com.tinhnd.day4day5.exception.BirthDayException;
import com.tinhnd.day4day5.exception.EmailException;
/**
 * Main
 * 
 * Version 1.0
 * 
 * Date 16-1-2018
 * 
 * Copyright
 * 
 * Modification logs DATE AUTHOR DESCRIPTION
 * ------------------------------------------------ 16-1-2018 TỉnhND Create
 *
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    static CandidateBO candidateBO = new CandidateBO();
    CertificateBO certificateBO = new CertificateBO();
    CandidateDAO candidateDAO = new CandidateDAO();
    ArrayList<CandidateBEAN> candidate = new ArrayList<CandidateBEAN>();
    Scanner sc = new Scanner(System.in);
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    final static String DATE_FORMAT = "dd/MM/yyyy";
   
    Date dateBirth = new Date();
    Date dateCertificateExp = new Date();
    Date dateCertificateFre = new Date();
    Date dateCertificateInt = new Date();
    Date dateGrad = new Date(); 

    int loaiUngVien;
    int loaiUngVienCapNhat;
    int loaiUngVienCapNhatDatabase;
    int IsContinue;
    int IsContinueCertificate;

    int countCandidate = 0;

    Date date = null;

    String candidateID = "";
    String fullName = "";
    static String birthDay = "";
    String phone = "";
    String email = "";

    String certificatedID = "";
    String certificateName = "";
    String certificateRank = "";
    String certificatedDate = "";

    String proSkill = "";
    int expInYear;
    
    String graduation_date;
    String graduation_rank;
    String education;
    
    String majors = "";
    String semester = "";
    String university_name = "";

    Boolean checkEmailContinue = false;
    Boolean checkBirthDayContinue = false;
    
    String query = "";
    int countFileLog = 0;
    /**
     * main 
     * @param args 
     * @return 
     * @throws
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.nhapLoaiUngVien();
//        main.inUngVienDatabase();
//        main.inUngVienFullName();
    }
  

    /**
     * Hàm nhập thêm ứng viên 
     * @param 
     * @return 
     * @throws
     */
    void nhapLoaiUngVien() {
        try {
            do {
                System.out.println("---------------------------------------------Thêm ứng viên---------------------------------------------");
                System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern, 3 - Cập nhật ứng viên, 4 - In danh sách");
                loaiUngVien = sc.nextInt();
                do {
                    switch (loaiUngVien) {
                    case 0:
                        nhapUngVien();
                        System.out.println("ExpInYear: ");
                            expInYear = sc.nextInt();
                        sc = new Scanner(System.in);
                        System.out.println("ProSkill: ");
                        proSkill = sc.nextLine();
                        try {
                            dateBirth = sdf.parse(birthDay);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
//                        candidateBO.addCandidateExp(candidateID, fullName, dateBirth, phone, email, loaiUngVien, expInYear, proSkill);
                        candidateDAO.insertCandidateExp(candidateID, fullName, birthDay, phone, email, loaiUngVien, expInYear, proSkill);
                        query = "INSERT dbo.Candidate( CandidateID ,FullName ,BirthDay ,Phone ,Email ,Candidate_type ,ExpInYear ,ProSkill ) "
                                + "VALUES  ("+ candidateID + " ,"+ fullName + " ,"+ birthDay +" ,"+ phone +" ,"+ email +" ,"+ loaiUngVien +" ,"+ expInYear +" ,"+ proSkill +" )";
                        countFileLog++;
                        writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
    
                        ExperienceBEAN experience = new ExperienceBEAN(candidateID, fullName, date, phone, email,loaiUngVien, expInYear, proSkill);
                        do {
                            sc = new Scanner(System.in);
                            System.out.println("CertificatedID: ");
                            certificatedID = sc.nextLine();
                            System.out.println("CertificateName: ");
                            certificateName = sc.nextLine();
                            System.out.println("CertificateRank: ");
                            certificateRank = sc.nextLine();
                            do {
                                System.out.println("CertificatedDate: ");
                                certificatedDate = sc.nextLine();
                                if (checkDay(certificatedDate) == false) {
                                    System.out.println("Sai định dạng ngày: ");
                                }
                            } while (checkDay(certificatedDate) == false);
                            CertificateBEAN certificateExp = new CertificateBEAN(certificatedID, certificateName,certificateRank, dateCertificateExp);
                            
                            try {
                                dateCertificateExp = sdf.parse(certificatedDate);
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            certificateBO.addCertificate(certificatedID, certificateName, certificateRank, dateCertificateExp, candidateID);
                            
                            query = "INSERT dbo.Candidate( CertificatedID ,CertificateName ,CertificateRank ,CertificatedDate ,CandidateID ) "
                                    + "VALUES  ("+ certificatedID + " ,"+ certificateName + " ,"+ certificateRank +" ,"+ dateCertificateExp +" ,"+ candidateID +" )";
                            countFileLog++;
                            writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                            
                            experience.AddCertificate(certificateExp);
                            System.out.println("Bạn có muốn nhập thêm bằng không ?:  0 - Không, 1 - Thêm tiếp");
                                IsContinueCertificate = sc.nextInt();
                            if (IsContinueCertificate == 0) {
                                break;
                            }
                        } while (IsContinueCertificate == 1);
                        candidate.add(experience);
    
                        do {
                            System.out.println("Bạn có muốn nhập tiếp hay không ?: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern, 3 - Cập nhật ứng viên, 4 - In danh sách");
                            loaiUngVien = sc.nextInt();
                        break;
    
                    case 1:
                        nhapUngVien();
                        do {
                            System.out.println("Graduation_date: ");
                            graduation_date = sc.nextLine();
                            if (checkDay(graduation_date) == false) {
                                System.out.println("Sai định dạng ngày !");
                            }
                        } while (checkDay(graduation_date) == false);
    
                        sc = new Scanner(System.in);
                        System.out.println("Graduation_rank: ");
                        graduation_rank = sc.nextLine();
                        System.out.println("Education: ");
                        education = sc.nextLine();
                        try {
                            dateBirth = sdf.parse(birthDay);
                            dateGrad = sdf.parse(graduation_date);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
//                        candidateBO.addCandidateFre(candidateID, fullName, dateBirth, phone, email, loaiUngVien, dateGrad, graduation_rank, education);
                        candidateDAO.addCandidateFre(candidateID, fullName, dateBirth, phone, email, loaiUngVien, dateGrad, graduation_rank, education);
                        query = "INSERT dbo.Candidate( CandidateID ,FullName ,BirthDay ,Phone ,Email ,Candidate_type ,Graduation_date ,Graduation_rank ,Education ) "
                                + "VALUES  ("+ candidateID + " ,"+ fullName + " ,"+ birthDay +" ,"+ phone +" ,"+ email +" ,"+ loaiUngVien +" ,"+ dateGrad +" ,"+ graduation_rank +" ,"+ education +")";
                        countFileLog++;
                        writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                        
                        FresherBEAN fresher = new FresherBEAN(candidateID, fullName,date, phone, email, loaiUngVien,graduation_date, graduation_rank, education);
                        do {
                            sc = new Scanner(System.in);
                            System.out.println("CertificatedID: ");
                            certificatedID = sc.nextLine();
                            System.out.println("CertificateName: ");
                            certificateName = sc.nextLine();
                            System.out.println("CertificateRank: ");
                            certificateRank = sc.nextLine();
                            do {
                                System.out.println("CertificatedDate: ");
                                certificatedDate = sc.nextLine();
                                if (checkDay(certificatedDate) == false) {
                                    System.out.println("Sai định dạng ngày: ");
                                }
                            } while (checkDay(certificatedDate) == false);
                            try {
                                dateCertificateFre = sdf.parse(certificatedDate);
                            } catch (ParseException e) {
                            }
    
                            CertificateBEAN certificateFre = new CertificateBEAN(certificatedID, certificateName,certificateRank, dateCertificateFre);
                            certificateBO.addCertificate(certificatedID, certificateName, certificateRank, dateCertificateFre, candidateID);
                            
                            query = "INSERT dbo.Candidate( CertificatedID ,CertificateName ,CertificateRank ,CertificatedDate ,CandidateID ) "
                                    + "VALUES  ("+ certificatedID + " ,"+ certificateName + " ,"+ certificateRank +" ,"+ dateCertificateExp +" ,"+ candidateID +" )";
                            countFileLog++;
                            writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                            
                            fresher.AddCertificate(certificateFre);
                            System.out.println( "Bạn có muốn nhập thêm bằng không ?:  0 - Không, 1 - Thêm tiếp");
                                IsContinueCertificate = sc.nextInt();
                            if (IsContinueCertificate == 0) {
                                break;
                            }
                        } while (IsContinueCertificate == 1);
                        candidate.add(fresher);
    
                        do {
                            System.out.println("Bạn có muốn nhập tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern, 3 - Cập nhật ứng viên, 4 - In danh sách");
                            loaiUngVien = sc.nextInt();
    
                        break;
    
                    case 2:
                        nhapUngVien();
    
                        sc = new Scanner(System.in);
                        System.out.println("Majors: ");
                        majors = sc.nextLine();
                        System.out.println("Semester: ");
                        semester = sc.nextLine();
                        System.out.println("University_name: ");
                        university_name = sc.nextLine();
                        try {
                            dateBirth = sdf.parse(birthDay);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
//                        candidateBO.addCandidateInt(candidateID, fullName, dateBirth, phone, email, loaiUngVien, majors, semester, university_name);
                        candidateDAO.addCandidateInt(candidateID, fullName, dateBirth, phone, email, loaiUngVien, majors, semester, university_name);
                        query = "INSERT dbo.Candidate( CandidateID ,FullName ,BirthDay ,Phone ,Email ,Candidate_type ,Majors ,Semester ,University_name ) "
                                + "VALUES  ("+ candidateID + " ,"+ fullName + " ,"+ birthDay +" ,"+ phone +" ,"+ email +" ,"+ loaiUngVien +" ,"+ majors +" ,"+ semester +" ,"+ university_name +")";
                        countFileLog++;
                        writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                        InternBEAN intern = new InternBEAN(candidateID, fullName, date, phone, email, loaiUngVien, majors, semester, university_name);
                        do {
                            sc = new Scanner(System.in);
                            System.out.println("CertificatedID: ");
                            certificatedID = sc.nextLine();
                            System.out.println("CertificateName: ");
                            certificateName = sc.nextLine();
                            System.out.println("CertificateRank: ");
                            certificateRank = sc.nextLine();
                            do {
                                System.out.println("CertificatedDate: ");
                                certificatedDate = sc.nextLine();
                                if (checkDay(certificatedDate) == false) {
                                    System.out.println("Sai định dạng ngày: ");
                                }
                            } while (checkDay(certificatedDate) == false);
                            try {
                                dateCertificateInt = sdf.parse(certificatedDate);
                            } catch (ParseException e) {
                            }
    
                            CertificateBEAN certificateInt = new CertificateBEAN(certificatedID, certificateName,certificateRank, dateCertificateInt);
                            certificateBO.addCertificate(certificatedID, certificateName, certificateRank, dateCertificateInt, candidateID);
                            
                            query = "INSERT dbo.Candidate( CertificatedID ,CertificateName ,CertificateRank ,CertificatedDate ,CandidateID ) "
                                    + "VALUES  ("+ certificatedID + " ,"+ certificateName + " ,"+ certificateRank +" ,"+ dateCertificateExp +" ,"+ candidateID +" )";
                            countFileLog++;
                            writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                            
                            intern.AddCertificate(certificateInt);
                            System.out.println("Bạn có muốn nhập thêm bằng không ?:  0 - Không, 1 - Thêm tiếp");
                            IsContinueCertificate = sc.nextInt();
                            if (IsContinueCertificate == 0) {
                                break;
                            }
                        } while (IsContinueCertificate == 1);
                        candidate.add(intern);
    
                        do {
                            System.out.println("Bạn có muốn nhập tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern, 3 - Cập nhật ứng viên, 4 - In danh sách");
                            loaiUngVien = sc.nextInt();
    
                        break;
                    case 3:
                        capNhatUngVien();
                        break;
                    case 4:
                        inUngVienDatabase();
                        
                        query = "SELECT CandidateID,FullName,BirthDay,Phone,Email,Candidate_type FROM dbo.Candidate";
                        countFileLog++;
                        writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                        
                        System.out.println();
                        
                        inUngVienFullName();
                        
                        query = "SELECT FullName FROM dbo.Candidate";
                        countFileLog++;
                        writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                        
                        do {
                            System.out.println();
                            System.out.println();
                            System.out.println("Bạn có muốn nhập tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern, 3 - Cập nhật ứng viên, 4 - In danh sách");
                            loaiUngVien = sc.nextInt();
                            
                        break;
                    }
                } while ((loaiUngVien == 0 || loaiUngVien == 1 || loaiUngVien == 2 || loaiUngVien == 3 || loaiUngVien == 4) && IsContinue == 1);
    
            } while (loaiUngVien != 0 && loaiUngVien != 1 && loaiUngVien != 2 && loaiUngVien != 3 & loaiUngVien != 4);
        } catch (Exception e) {
            System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
            return;
        }
    }
    /**
     * Hàm cập nhật ứng viên 
     * @param 
     * @return 
     * @throws
     */
    void capNhatUngVien() {
        try {
            do {
                System.out.println("---------------------------------------------Câp nhật ứng viên---------------------------------------------");
                System.out.println("Nhập loại ứng viên cần cập nhật: 0 - Experence, 1 - Fresher, 2 - Intern,3 - Thêm ứng viên, 4 - In danh sách");
                loaiUngVienCapNhat = sc.nextInt();
                do {
                    switch (loaiUngVienCapNhat) {
                    case 0:
                        nhapUngVienCapNhat();
                        do {
                            System.out.println("Loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern");
                            loaiUngVienCapNhatDatabase = sc.nextInt();
                            if(loaiUngVienCapNhatDatabase == 0 || loaiUngVienCapNhatDatabase == 1 || loaiUngVienCapNhatDatabase == 2)
                                break;
                        }while(loaiUngVienCapNhatDatabase != 0 || loaiUngVienCapNhatDatabase != 1 || loaiUngVienCapNhatDatabase != 2);
                        System.out.println("ExpInYear: ");
                        expInYear = sc.nextInt();
                        sc = new Scanner(System.in);
                        System.out.println("ProSkill: ");
                        proSkill = sc.nextLine();
                        try {
                            dateBirth = sdf.parse(birthDay);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        candidateDAO.updateCandidateExp(candidateID, fullName, dateBirth, phone, email, loaiUngVienCapNhatDatabase, expInYear, proSkill);
    
                        query = "UPDATE dbo.Candidate SET FullName = "+ fullName +", BirthDay = "+ dateBirth +", Phone = "+ phone +", Email = "+ email +",Candidate_type = "+ 
                        loaiUngVienCapNhatDatabase +", ExpInYear = "+ expInYear +", ProSkill = "+ proSkill +" WHERE CandidateID =  " + candidateID;
                        countFileLog++;
                        writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                        
                        ExperienceBEAN experience = new ExperienceBEAN(candidateID, fullName, date, phone, email,loaiUngVienCapNhat, expInYear, proSkill);
//                      
                        candidate.add(experience);
    
                        do {
                            System.out.println("Bạn có muốn cập nhật tiếp hay không ?: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại ứng viên cần cập nhật: 0 - Experence, 1 - Fresher, 2 - Intern,3 - Thêm ứng viên, 4 - In danh sách");
                        loaiUngVienCapNhat = sc.nextInt();
                        break;
    
                    case 1:
                        nhapUngVienCapNhat();
                        do {
                            System.out.println("Loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern");
                            loaiUngVienCapNhatDatabase = sc.nextInt();
                            if(loaiUngVienCapNhatDatabase == 0 || loaiUngVienCapNhatDatabase == 1 || loaiUngVienCapNhatDatabase == 2)
                                break;
                        }while(loaiUngVienCapNhatDatabase != 0 || loaiUngVienCapNhatDatabase != 1 || loaiUngVienCapNhatDatabase != 2);
                        do {
                            System.out.println("Graduation_date: ");
                            graduation_date = sc.nextLine();
                            if (checkDay(graduation_date) == false) {
                                System.out.println("Sai định dạng ngày !");
                            }
                        } while (checkDay(graduation_date) == false);
    
                        sc = new Scanner(System.in);
                        System.out.println("Graduation_rank: ");
                        graduation_rank = sc.nextLine();
                        System.out.println("Education: ");
                        education = sc.nextLine();
                        try {
                            dateBirth = sdf.parse(birthDay);
                            dateGrad = sdf.parse(graduation_date);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        candidateDAO.updateCandidateFre(candidateID, fullName, dateBirth, phone, email, loaiUngVienCapNhatDatabase, dateGrad, graduation_rank, education);
                      
                        query = "UPDATE dbo.Candidate SET FullName = "+ fullName +", BirthDay = "+ dateBirth +", Phone = "+ phone +", Email = "+ email +",Candidate_type = "+ 
                                loaiUngVienCapNhatDatabase +", Graduation_date = "+ dateGrad +", Graduation_rank = "+ graduation_rank +", Education = "+ education +" + WHERE CandidateID =  " + candidateID;
                                countFileLog++;
                                writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                        
                        FresherBEAN fresher = new FresherBEAN(candidateID, fullName,date, phone, email, loaiUngVienCapNhat,graduation_date, graduation_rank, education);
//                        
                        candidate.add(fresher);
    
                        do {
                            System.out.println("Bạn có muốn cập nhật tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại ứng viên cần cập nhật: 0 - Experence, 1 - Fresher, 2 - Intern,3 - Thêm ứng viên, 4 - In danh sách");
                        loaiUngVienCapNhat = sc.nextInt();
                        break;
    
                    case 2:
                            nhapUngVienCapNhat();
                            do {
                                System.out.println("Loại ứng viên: 0 - Experence, 1 - Fresher, 2 - Intern");
                                loaiUngVienCapNhatDatabase = sc.nextInt();
                                if(loaiUngVienCapNhatDatabase == 0 || loaiUngVienCapNhatDatabase == 1 || loaiUngVienCapNhatDatabase == 2)
                                    break;
                            }while(loaiUngVienCapNhatDatabase != 0 || loaiUngVienCapNhatDatabase != 1 || loaiUngVienCapNhatDatabase != 2);
                            sc = new Scanner(System.in);
                            System.out.println("Majors: ");
                            majors = sc.nextLine();
                            System.out.println("Semester: ");
                            semester = sc.nextLine();
                            System.out.println("University_name: ");
                            university_name = sc.nextLine();
                            try {
                                dateBirth = sdf.parse(birthDay);
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            candidateDAO.updateCandidateInt(candidateID, fullName, dateBirth, phone, email, loaiUngVienCapNhatDatabase, majors, semester, university_name);
                           
                            query = "UPDATE dbo.Candidate SET FullName = "+ fullName +", BirthDay = "+ dateBirth +", Phone = "+ phone +", Email = "+ email +",Candidate_type = "+ 
                                    loaiUngVienCapNhatDatabase +", Majors = "+ majors +", Semester = "+ semester +", University_name = "+ university_name +" + WHERE CandidateID =  " + candidateID;
                                    countFileLog++;
                                    writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                            
                            InternBEAN intern = new InternBEAN(candidateID, fullName, date, phone, email, loaiUngVienCapNhat, majors, semester, university_name);
    
                            candidate.add(intern);
        
                            do {
                                System.out.println("Bạn có muốn cập nhật tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                                    IsContinue = sc.nextInt();
                            } while (IsContinue != 0 && IsContinue != 1);
                            if (IsContinue == 0) {
                                break;
                            }
                            System.out.println("Nhập loại ứng viên cần cập nhật: 0 - Experence, 1 - Fresher, 2 - Intern,3 - Thêm ứng viên, 4 - In danh sách");
                            loaiUngVienCapNhat = sc.nextInt();
                            break;
                        case 3:
                            nhapLoaiUngVien();
                            break;
                        case 4:
                            inUngVienDatabase();
                            
                            query = "SELECT CandidateID,FullName,BirthDay,Phone,Email,Candidate_type FROM dbo.Candidate";
                            countFileLog++;
                            writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                            
                            System.out.println();
                            
                            inUngVienFullName();
                            
                            query = "SELECT FullName FROM dbo.Candidate";
                            countFileLog++;
                            writeFileLog("\nSố lần truy vấn: " + countFileLog + "\nNội dung: " + query);
                            do {
                                System.out.println();
                                System.out.println();
                                System.out.println("Bạn có muốn cập nhật tiếp hay không: 0 - Dừng, 1 - Tiếp tục");
                                    IsContinue = sc.nextInt();
                            } while (IsContinue != 0 && IsContinue != 1);
                            if (IsContinue == 0) {
                                break;
                            }
                            System.out.println("Nhập loại ứng viên cần cập nhật: 0 - Experence, 1 - Fresher, 2 - Intern,3 - Thêm ứng viên, 4 - In danh sách");
                            loaiUngVienCapNhat = sc.nextInt();
                            
                    }
                } while ((loaiUngVienCapNhat == 0 || loaiUngVienCapNhat == 1 || loaiUngVienCapNhat == 2 || loaiUngVienCapNhat == 3 || loaiUngVienCapNhat == 4 )&& IsContinue == 1);
    
            } while (loaiUngVienCapNhat != 0 && loaiUngVienCapNhat != 1 && loaiUngVienCapNhat != 2 && loaiUngVienCapNhat != 3 && loaiUngVienCapNhat != 4);
        } catch (Exception e) {
            System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
            return;
        }
    }
    /**
     * Hàm nhập ứng viên 
     * @param 
     * @return 
     * @throws
     */
    void nhapUngVien() {
        sc = new Scanner(System.in);
        do {
            System.out.println("CandidateID: ");
            candidateID = sc.nextLine();
            if(checkCandidateID(candidateID))
            {
                System.out.println("Mã ứng viên đã tồn tại, vui lòng nhập mã khác ! ");
            }
        }while(checkCandidateID(candidateID));
        
        System.out.println("FullName: ");
        fullName = sc.nextLine();
//        do {
//            System.out.println("BirthDay: ");
//                birthDay = sc.nextLine();
//            if (checkDay(birthDay) == false) {
//                System.out.println("Sai định dạng ngày !");
//            }
//        } while (checkDay(birthDay) == false);
        do {
            System.out.println("BirthDay: ");
                birthDay = sc.nextLine();
                try{  
                    validateBirthDay(birthDay);  
                    checkBirthDayContinue =  false;
                    }catch(Exception m){
                    System.out.println("Đã xảy ra lỗi: " + m);
                    checkBirthDayContinue = true;
                    writeFileLog(m.toString());
                }  
        } while (checkBirthDayContinue);
        try {
            date = sdf.parse(birthDay);
        } catch (ParseException e) {
        }
        do {
            System.out.println("Phone: ");
            phone = sc.nextLine();
            if (checkPhone(phone) == false) {
                System.out.println("Số điện thoại không hợp lệ ! ");
            }
        } while (checkPhone(phone) == false);
//        do {
//            System.out.println("Email: ");
//                email = sc.nextLine();
//            if (checkEmail(email) == false) {
//                System.out.println("Email không hợp lệ ! ");
//            }
//        } while (checkEmail(email) == false);
          do {
              System.out.println("Email: ");
                email = sc.nextLine();
              try{  
                  validateEmail(email);  
                  checkEmailContinue = false;
                  }catch(Exception m2){
                  System.out.println("Đã xảy ra lỗi: " + m2);
                  checkEmailContinue = true;
                  writeFileLog(m2.toString());
              }  
          } while (checkEmailContinue);
               
    }
    /**
     * Hàm nhập ứng viên cần cập nhật 
     * @param 
     * @return 
     * @throws
     */
    void nhapUngVienCapNhat() {
        sc = new Scanner(System.in);
        do {

            System.out.println("CandidateID: ");
            candidateID = sc.nextLine();
            if(!checkCandidateID(candidateID))
            {
                System.out.println("Mã ứng viên đã không tại, vui lòng nhập mã khác ! ");
            }
        }while(!checkCandidateID(candidateID));
        
        System.out.println("FullName: ");
        fullName = sc.nextLine();
//        do {
//            System.out.println("BirthDay: ");
//                birthDay = sc.nextLine();
//            if (checkDay(birthDay) == false) {
//                System.out.println("Sai định dạng ngày !");
//            }
//        } while (checkDay(birthDay) == false);
        do {
            System.out.println("BirthDay: ");
                birthDay = sc.nextLine();
                try{  
                    validateBirthDay(birthDay);  
                    checkBirthDayContinue =  false;
                    }catch(Exception m){
                    System.out.println("Đã xảy ra lỗi: " + m);
                    checkBirthDayContinue = true;
                    writeFileLog(m.toString());
                    
                }  
        } while (checkBirthDayContinue);
        try {
            date = sdf.parse(birthDay);
        } catch (ParseException e) {
        }
        do {
            System.out.println("Phone: ");
            phone = sc.nextLine();
            if (checkPhone(phone) == false) {
                System.out.println("Số điện thoại không hợp lệ ! ");
            }
        } while (checkPhone(phone) == false);
//        do {
//            System.out.println("Email: ");
//                email = sc.nextLine();
//            if (checkEmail(email) == false) {
//                System.out.println("Email không hợp lệ ! ");
//            }
//        } while (checkEmail(email) == false);
          do {
              System.out.println("Email: ");
                email = sc.nextLine();
              try{  
                  validateEmail(email);  
                  checkEmailContinue = false;
                  }catch(Exception m2){
                  System.out.println("Đã xảy ra lỗi: " + m2);
                  checkEmailContinue = true;
                  writeFileLog(m2.toString());
              }  
          } while (checkEmailContinue);
               
    }

    /**
     * Hàm in danh sách ứng viên trong bộ nhớ
     * @param 
     * @return 
     * @throws
     */
    void inUngVien() {
            for (CandidateBEAN cand : candidate) {
                if (cand instanceof ExperienceBEAN) { // instanceof là toán tử so sánh,trả về đúng hoặc sai, và kiểm tra xem đối tượng là một thể hiện của kiểu được chỉ định
                    System.out.println();
                    System.out.println( "Mã ứng viên; Họ tên; Ngày sinh; Số điện thoại; Email; Loại ứng viên; Số năm kinh nghiệm; Kỹ năng chuyên môn");
                    System.out.println(((ExperienceBEAN) cand).ShowInfo() + ((ExperienceBEAN) cand).ShowMe());
                    countCandidate++;
                        System.out.println();
                        System.out.println("Mã bằng; Tên bằng; Loại bằng; Ngày cấp ");
                    ((ExperienceBEAN) cand).ShowCertificate();
                    countCandidate = ((ExperienceBEAN) cand).candidate_count;
                }
                if (cand instanceof FresherBEAN) { // instanceof là toán tử so sánh,trả về đúng hoặc sai, và kiểm tra xem đối tượng là một thể hiện của kiểu được chỉ định
                    System.out.println();
                    System.out.println( "Mã ứng viên; Họ tên; Ngày sinh; Số điện thoại; Email; Loại ứng viên; Ngày tốt nghiệp; Loại tốt nghiệp; Trường");
                    System.out.println(((FresherBEAN) cand).ShowInfo() + ((FresherBEAN) cand).ShowMe());
                    countCandidate++;
                        System.out.println();
                        System.out.println("Mã bằng; Tên bằng; Loại bằng; Ngày cấp ");
                    ((FresherBEAN) cand).ShowCertificate();
                    countCandidate = ((FresherBEAN) cand).candidate_count;
                }
                    if (cand instanceof InternBEAN) { // instanceof là toán tử so sánh,trả về đúng hoặc sai, và kiểm tra xem đối tượng là một thể hiện của kiểu được chỉ định
                        System.out.println();
                    System.out.println("Mã ứng viên; Họ tên; Ngày sinh; Số điện thoại; Email; Loại ứng viên; Chuyên ngành; Học kỳ; Trường đang học");
                    System.out.println(((InternBEAN) cand).ShowInfo() + ((InternBEAN) cand).ShowMe());
                    countCandidate++;
                        System.out.println();
                        System.out.println("Mã bằng; Tên bằng; Loại bằng; Ngày cấp ");
                    ((InternBEAN) cand).ShowCertificate();
                    countCandidate = ((InternBEAN) cand).candidate_count;
                }
            }
            System.out.println();
            System.out.println("Số lượng ứng viên: " + countCandidate);
    }
  
    /**
     * Hàm in danh sách ứng viên trong database
     * @param 
     * @return 
     * @throws
     */
    void inUngVienDatabase() {
        System.out.println( "Mã ứng viên; Họ tên; Ngày sinh; Số điện thoại; Email; Loại ứng viên");
        System.out.println();
        if(candidateBO.getListCandidate() != null) {
            for (CandidateBEAN cand : sort(candidateBO.getListCandidate())) {
                    System.out.println(cand.getCandidateID() + "; " + cand.getFullName() + "; " + sdf.format(cand.getBirthDay()) + "; " + cand.getPhone() + "; " + cand.getEmail() + "; " + cand.getCandidate_type());
            }
        }
    }
    /**
     * Hàm sắp xếp danh sách ứng viên
     * @param cand
     * @return cand
     * @throws
     */
    private static ArrayList<CandidateBEAN> sort(ArrayList<CandidateBEAN> cand){
        Collections.sort(cand, new Comparator<CandidateBEAN>() {

            @Override
            public int compare(CandidateBEAN c1, CandidateBEAN c2) {
                if(c1.getCandidate_type() < c2.getCandidate_type()) {
                    return -1;
                }else {
                    if(c1.getCandidate_type() == c2.getCandidate_type()) {
                        if(c1.getBirthDay().after(c2.getBirthDay())) {
                            return 1;
                        }else  if(c1.getBirthDay().before(c2.getBirthDay())){
                            return -1;
                        }else
                        return 0;
                    }else 
                    return 1;
                }
            }
        });
        return cand;
    }
 
    /**
     * Hàm in họ tên ứng viên 
     * @param 
     * @return 
     * @throws
     */
    void inUngVienFullName() {
        System.out.println("Họ tên: ");
        System.out.println("Test Hashcode của String:");
        String str = "";
        if(candidateBO.getListCandidate() != null) {
            for (CandidateBEAN cand : candidateBO.getListCandidate()) {
                    System.out.print(cand.getFullName() + ", ");
                    str = cand.getFullName();
                    System.out.print(str.hashCode() + ", ");
    //                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println("Họ tên: ");
            System.out.println("Test Hashcode của StringBuffer:");
            StringBuffer sb = new StringBuffer();
            for (CandidateBEAN cand : candidateBO.getListCandidate()) {
                    System.out.print(cand.getFullName() + ", ");
                    sb.append(cand.getFullName() );
                    System.out.print(sb.hashCode() + ", ");
    //                System.out.println();
            }
        }
    }
    /**
     * Hàm kiểm tra mã ứng viên trùng
     * @param id
     * @return 
     * @throws
     */
    boolean checkCandidateID(String id) {
        for (CandidateBEAN cand : candidateBO.getListCandidate()) {
            if(id.equals(cand.getCandidateID())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Hàm kiểm tra ngày 
     *@param date 
     * @return 
     * @throws
     */

    private static boolean checkDay(String date) {
        String s[] = date.split("[/]");
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            Date today = new Date();
            Date myDay = sdf.parse(date);
            if(Integer.parseInt(s[2]) < 1900) {
                return false;
            }
            if(today.getTime() < myDay.getTime()) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Hàm kiểm email hợp lệ
     * @param email 
     * @return 
     * @throws
     */

    private static void validateEmail(String email)throws EmailException{  
        if(!checkEmail(email)) {  
         throw new EmailException("Email không hợp lệ !");
         
//         logger.info("Logging begins...");   // log INFO-level message
//         try {
//            // Simulating an Exception
//            throw new Exception("Simulating an exception");
//         } catch (Exception ex){
//            logger.log(Level.SEVERE, ex.getMessage(), ex);
//         }
//         logger.info("Done...");

         }  
      }  
    
    /**
     * Hàm kiểm ngày sinh hợp lệ
     * @param email 
     * @return 
     * @throws
     */
    private static void validateBirthDay(String date)throws BirthDayException{  
        if(!checkDay(date)) {  
         throw new BirthDayException("Ngày sinh không hợp lệ !");
         }  
      }  
    

    /**
     * Hàm kiểm tra số điện thoại 
     * @param sdtPhone 
     * @return 
     * @throws
     */
    private static boolean checkPhone(String sdtPhone) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(sdtPhone);
        if (!matcher.matches()) {
            return false;
        } else if (sdtPhone.length() == 9 || sdtPhone.length() == 10) {
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
     * Hàm kiểm tra email 
     * @param stdEmail 
     * @return 
     * @throws
     */
    private static boolean checkEmail(String stdEmail) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(stdEmail);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Hàm ghi ra file log
     * @param content
     * @return 
     * @throws
     */
    public static void writeFileLog(String content)
    {
        Handler fh = null;
        try {
            fh = new FileHandler("./InfoLog.log", true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        logger.addHandler(fh);
        logger.setLevel(Level.FINE);
   
        try {
           throw new Exception(content);
        } catch (Exception ex){
        }
        logger.info(content);
   
        fh.flush();
        fh.close();
    }
    
}
