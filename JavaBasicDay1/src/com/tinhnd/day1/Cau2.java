package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau2: Chương trình tính :
        S=1+1/2+1/3+....+1/n
        Số n được nhập từ bàn phím
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
public class Cau2 {
    /**
     *   main
     *   @param args
     *   @return Tổng giá trị
     *   @throws     
     */
    public static void main(String[] args) {
        int n;
        float s = 0f;
        System.out.println("Nhập n = ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n ; i++) {
            s += 1/(float)i;
        }
        System.out.println("Kết quả = " + s);
    }

}
