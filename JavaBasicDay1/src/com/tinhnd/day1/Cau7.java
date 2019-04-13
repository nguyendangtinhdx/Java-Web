package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau7: Nhập vào một String S,  thực hiện công việc sau:
    a.  In ra màn hình String đảo ngược của S
    b.  Đổi toàn bộ kí tự của S sang chữ Hoa
    c.  Đổi toàn bộ kí tự của S sang chữ thường
    d.  Đưa ra bảng tần số xuất hiện của các kí tự trong S
    e.  Trích ra chuỗi con của từ kí tự thứ n đến thứ m của S (n, m nhập từ bàn phím)
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
public class Cau7 {
    /**
     *   main
     *   @param args
     *   @return 1 chuỗi đảo ngược, 1 chuỗi đổi sang chữ Hoa, 1 chuỗi đổi sang chữ thường, số lần xuất hiện các kí tự của 1 chuỗi,1 chuỗi từ kí tự thứ n đếm thứ m
     *   @throws     
     */
    public static void main(String[] args) {
        String s = "";
        System.out.println("Nhập vào 1 chuỗi s = ");
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        String reverse = new StringBuffer(s).reverse().toString();
        System.out.println("Chuỗi " + s + " đảo ngược thành: " + reverse);
        System.out.println("Chuỗi " + s + " sang chữ hoa thành: " + s.toUpperCase());
        System.out.println("Chuỗi " + s + " sang chữ thường thành: " + s.toLowerCase());
        
        int[] mangDem = new int[Character.MAX_VALUE];

        for(int i=0;i<s.length();i++){
                mangDem[s.charAt(i)]++;
        }
        for(int i=0;i<mangDem.length;i++){
            if(mangDem[i]!=0){
                System.out.println((char)i + ":" + mangDem[i]);
            }
        }
    int n ,m;
    System.out.println("Nhập vào kí tự bắt đầu n = ");
    n = sc.nextInt();
    System.out.println("Nhập vào kí tự kết thúc m = ");
    m = sc.nextInt();
    System.out.println("Chuỗi sau khi trích là: " + s.toLowerCase().substring(n, m));
    }
}
