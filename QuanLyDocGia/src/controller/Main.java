package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import dao.BorrowDAO;
import exception.InvalidDateException;
import exception.InvalidInput;


public class Main {
    BorrowDAO borrowDAO = new BorrowDAO();
    Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
    final static String DATE_FORMAT = "YYYYMMDD";
    Date dateBorrow = new Date();
    Date dateTime = new Date();
    int loaiSinhVien;
    int IsContinue;
    String studentID = "";
    String trainerID = "";
    String bookID = "";
    String borrowDate = "";
    String borrowTime = "";
    int month ;
    Boolean checkBirthDayContinue = false;
    public static void main(String[] args) throws IOException {
        String[][] mangChuaFile1 = DocFile1();
        String[][] mangChuaFile2 = DocFile2();
//        XuatMang2Chieu(mangChuaFile1);
//        System.out.println();
//        XuatMang2Chieu(mangChuaFile2);
        
        Main main = new Main();
        main.nhapLoaiSinhVien();
    }
    void nhapLoaiSinhVien() {
        try {
            do {
                System.out.println("---------------------------------------------Nhập loại sinh viên ---------------------------------------------");
                System.out.println("Nhập loại sinh viên: 0 - StudentDN, 1 - StudentLocalEchange, 2 - In danh sách");
                loaiSinhVien = sc.nextInt();
                sc = new Scanner(System.in);
                do {
                    switch (loaiSinhVien) {
                    case 0:
                        sc = new Scanner(System.in);
                        System.out.println("StudentID: ");
                        studentID = sc.nextLine();
//                        try{  
//                            validateInput(studentID);  
//                            }catch(Exception m){
//                            System.out.println("Đã xảy ra lỗi: " + m);
//                            return;
//                            }
                        System.out.println("TrainerID: ");
                        trainerID = sc.nextLine();
//                        try{  
//                          validateInput(trainerID);  
//                          }catch(Exception m){
//                          System.out.println("Đã xảy ra lỗi: " + m);
//                          return;
//                          }
                        System.out.println("BookID: ");
                        bookID = sc.nextLine();
//                        try{  
//                            validateInput(bookID);  
//                            }catch(Exception m){
//                            System.out.println("Đã xảy ra lỗi: " + m);
//                            return;
//                            }
                        System.out.println("BorrowDate: ");
                        borrowDate = sc.nextLine();
                        try {
                            dateBorrow = sdf.parse(borrowDate);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        do {
                            System.out.println("BorrowDate: ");
                            borrowDate = sc.nextLine();
                                try{  
                                    validateDate(borrowDate);  
                                    checkBirthDayContinue =  false;
                                    }catch(Exception m){
                                    System.out.println("Đã xảy ra lỗi: " + m);
                                    checkBirthDayContinue = true;
                                }  
                        } while (checkBirthDayContinue);
                        try {
                            dateBorrow = sdf.parse(borrowDate);
                        } catch (ParseException e) {
                        }
                        System.out.println("BorrowTime: ");
                        borrowTime = sc.nextLine();
                        try {
                            dateTime= sdf.parse(borrowTime);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        borrowDAO.insert(studentID, trainerID, bookID, dateBorrow, dateTime);
    
                        do {
                            System.out.println("Bạn có muốn nhập tiếp hay không ?: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại sinh viên: 0 - StudentDN, 1 - StudentLocalEchange, 2 - In danh sách");
                        loaiSinhVien = sc.nextInt();
                        break;
    
                    case 1:
                        sc = new Scanner(System.in);
                        System.out.println("StudentID: ");
                        studentID = sc.nextLine();
                        sc = new Scanner(System.in);
                        System.out.println("TrainerID: ");
                        trainerID = sc.nextLine();
                        System.out.println("BookID: ");
                        bookID = sc.nextLine();
                        System.out.println("BorrowDate: ");
                        borrowDate = sc.nextLine();
                        try {
                            dateBorrow = sdf.parse(borrowDate);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        System.out.println("BorrowTime: ");
                        borrowTime = sc.nextLine();
                        try {
                            dateTime= sdf.parse(borrowTime);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
//                        candidateDAO.insertCandidateExp(candidateID, fullName, birthDay, phone, email, loaiSinhVien, expInYear, proSkill);

    
                        do {
                            System.out.println("Bạn có muốn nhập tiếp hay không ?: 0 - Dừng, 1 - Tiếp tục");
                                IsContinue = sc.nextInt();
                        } while (IsContinue != 0 && IsContinue != 1);
                        if (IsContinue == 0) {
                            break;
                        }
                        System.out.println("Nhập loại sinh viên: 0 - StudentDN, 1 - StudentLocalEchange, 2 - In danh sách");
                        loaiSinhVien = sc.nextInt();
                        break;
    
                    case 2:
                        String[][] mangChuaFile1 = DocFile1();
                        String[][] mangChuaFile2 = DocFile2();
                      XuatMang2Chieu(mangChuaFile1);
                      System.out.println();
                      XuatMang2Chieu(mangChuaFile2);
                        break;
                    }
                } while ((loaiSinhVien == 0 || loaiSinhVien == 1 || loaiSinhVien == 2 ) && IsContinue == 1);
    
            } while (loaiSinhVien != 0 && loaiSinhVien != 1 && loaiSinhVien != 2 );
        } catch (Exception e) {
            System.out.println("He thong dang gap su co mong cac ban thong cam. Vui long truy cap lai sau !");
            return;
        }
    }
    /**
     *   Hàm đọc file
     *   @param 
     *   @return 
     *   @throws IOException    
     */
    private static final String FILEREAD1 = "./input1.csv";
    private static final String FILEREAD2 = "./input2.csv";
    @SuppressWarnings("resource")
    private static String[][] DocFile1() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(FILEREAD1));
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
            br = new BufferedReader(new FileReader(FILEREAD1));
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

    @SuppressWarnings("resource")
    private static String[][] DocFile2() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(FILEREAD2));
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
            br = new BufferedReader(new FileReader(FILEREAD2));
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
                System.out.print(a[chiSoDong][chiSoCot] + ";");
            System.out.println();
        }
    }
    private static boolean checkDay(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            DateFormat df2 = new SimpleDateFormat("1950/01/01");
            DateFormat df3 = new SimpleDateFormat("2050/01/01");
            df.setLenient(false);
            df.parse(date);
            if(df.parse(date).after(df2.parse(date)) &&  df.parse(date).before(df3.parse(date))) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    private static void validateDate(String date)throws InvalidDateException{  
        if(!checkDay(date)) {  
         throw new InvalidDateException("Ngày sinh không hợp lệ !");
         }  
      }  
    private static boolean checkID(String id) throws ParseException {
        BorrowDAO borrowDAO = new BorrowDAO();
        if(borrowDAO.checkBookID().equals(id) || borrowDAO.checkStudentID().equals(id) || borrowDAO.checkTrainerID().equals(id)) {
            return false;
        }
        return true;
    }
    
    private static void validateInput(String id)throws InvalidInput, ParseException{  
        if(!checkID(id)) {  
         throw new InvalidInput("ID đã tồn tại !");
         }  
      }  
    
}
