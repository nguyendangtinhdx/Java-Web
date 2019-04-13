package com.tinhnd.day1;

import java.util.Scanner;

/**
 * Cau1: Chương trình in ra các dấu * theo cấu trúc như sau (cho n là chiều cao của tháp tam giác, cần in ra n dòng):
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

public class Cau1 {
    /**
     *   main
     *   @param args
     *   @return hình tam giác *
     *   @throws     
     */
    public static void main(String args[]){  
            int n;
            System.out.println("Nhập vào chiều cao n = ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            for ( int i = 1; i <=n; i++){
                for ( int j = 1; j <= i; j ++) 
                    System.out.print("* ");
                System.out.println("");
            }
                    
         }  
}
