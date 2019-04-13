package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau6: Chương trình nhập vào một số nguyên dương n. Sau đó quy đổi n ra hệ nhị phân.
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
public class Cau6 {
    
    /**
     *   main
     *   @param args
     *   @return Giá trị nhị phân của 1 số 
     *   @throws     
     */
    public static void main(String[] args) {
        int n; 
       do {
            System.out.println("Nhập số nguyên dương n = ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
       }while(n <= 0);
       System.out.println("Số " + n + " trong hệ nhị phân = "
               + Integer.toBinaryString(n));

    }

}
