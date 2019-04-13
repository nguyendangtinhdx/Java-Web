package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau5: Nhập 2 số nguyên dương a và b. Sau đó in ra ước số chung lớn nhất và bội số chung nhỏ nhất của 2 số nguyên dương a và b đó.
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
public class Cau5 {
    /**
     *   main
     *   @param args
     *   @return Giá trị của UCLN và BCNN
     *   @throws     
     */
    public static void main(String[] args) {
        int n,m, ucln = 0,bcnn = 0 ; 
        System.out.println("Nhập sô thứ nhất = ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("Nhập sô thứ hai = ");
        m = sc.nextInt();
        
        System.out.println("UCLN của " + n + " và " + m + " là: " + UCLN(n, m));
        System.out.println("BCNN của " + n + " và " + m + " là: " +((n*m) / UCLN(n, m)));
    }
    /*
     * hàm tìm UCLN
     */
    private static int UCLN(int a, int b) {
        while(a!=b) {
            if(a>b)
                a-=b;
            else
                b-=a;
        }
        return a;
    }
}
