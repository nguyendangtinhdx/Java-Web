package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau3: Chương trình tính  :
        S = 1+1/3!+1/5!+…..+1/(2n-1)!
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
public class Cau3 {
    /**
     *   main
     *   @param args
     *   @return Tổng giá trị
     *   @throws     
     */
    public static void main(String[] args) {
        int i,n,giai_thua = 1,m = 1; 
        float s = 0f; 
        System.out.println("Nhập n = ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = 2*n - 1;
        for (i=1;i<=m;i+=2) 
        { 
            giai_thua = GiaiThua(i); 
            s =(s + (float)1/giai_thua); 
        } 
        System.out.println("Tổng = " + s);
    }
    /*
     * hàm tính giai thừa
     */
    private static int GiaiThua(int x) 
    { 
        if(x<0) return x; 
        if(x==1) return 1; 
        else return (x*GiaiThua(x-1)); 
    } 

}
