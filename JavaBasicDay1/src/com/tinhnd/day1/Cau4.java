package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau4: Tính tổng và tích các chữ số của một số m, m được nhập từ bàn phím
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
public class Cau4 {

    /**
     *   main
     *   @param args
     *   @return Tổng giá trị
     *   @throws     
     */
    public static void main(String[] args) {
        int m, p = 1,s = 0 ; 
        System.out.println("Nhập m = ");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        while(m > 0) {
            s += m%10;
            p *= m%10;
            m /= 10;
        }
        System.out.println("Tổng các chữ số = " + s);
        System.out.println("Tích các chữ số = " + p);
    }

}
