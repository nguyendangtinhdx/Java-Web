package com.tinhnd.day1;

import java.util.Scanner;
/**
 * Cau8:Chương trình thực hiện các công việc như sau :
        a.  Nhập một mảng a gồm n phần tử kiểu nguyên int
        b.  Tính tổng số dương lẻ của mảng a
        c.  Nhập vào phần tử k, tìm xem k có xuất hiện trong mảng a không. Nếu có chỉ ra các vị trí của k trong mảng.
        d.  Sắp sếp mảng a theo thứ tự tăng dần.
        e.  Chèn một số p vào mảng a sao cho mảng a vẫn đảm bảo tăng dần.
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
public class Cau8 {

    public static Scanner sc = new Scanner(System.in);
    /**
     *   main
     *   @param args
     *   @return Tổng giá trị số dương lẻ của mảng a, Vị trí của k trong mảng, 1 mảng được sắp xếp tăng dần , 1 mảng tăng dần sau khi được chèn p vào
     *   @throws     
     */
    public static void main(String[] args) {
        System.out.print("Nhập số phần tử của mảng A: ");
        int n = sc.nextInt();
        // khởi tạo mảng a
        int [] a = new int [n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] =  ");
            a[i] = sc.nextInt();
        }
        System.out.print("Mảng A: ");
        in(a);
        System.out.println("");
        System.out.println("Tổng các số dương và lẻ = " + Tong(a));
        System.out.println("Nhập phần tử k cần tìm trong mảng a = ");
        int k = sc.nextInt();
        System.out.println("Vị trí thứ " + k + " của mảng = " +  Tim(a,k));
        System.out.print("Sắp xếp mảng tăng dần: ");
        sapXep(a);
        in(a);
        System.out.println("");
        System.out.println("Nhập phần tử cần chèn p = ");
        int p = sc.nextInt();
        a = chen(a, p);
        System.out.print("Mảng A sau khi chèn: ");
        in(a);
    }
    
    /**
     *   Hàm tìm vị trí của phần tử trong mảng
     *   @param a, k
     *   @return Vị trí
     *   @throws     
     */
    private static int Tim(int[]a,  int k)
    {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == k) {
                return i;
            }
        }
        return -1;
    }
    /**
     *   Hàm tính tổng số dương lẻ của mảng a
     *   @param a
     *   @return sum
     *   @throws     
     */
    public static int Tong(int[] a)
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > 0 && a[i] % 2 != 0) {
                sum+= a[i];
            }
        }
        return sum;
    }
    /**
     *   Hàm sắp sếp mảng a theo thứ tự tăng dần
     *   @param a
     *   @return
     *   @throws     
     */
    public static void sapXep(int [] a) {
        int x = a[0];
        for (int i = 0 ; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    x = a[j];
                    a[j] = a[i];
                    a[i] = x;
                }
            }
        }
    }
     
    /**
     *   Hàm chèn một số p vào mảng a
     *   @param a, k
     *   @return
     *   @throws     
     */
    public static int [] chen(int [] a, int k) {
        int aIndex = a.length - 1;
        int xIndex = a.length;
        int [] b = new int [xIndex + 1];
        boolean chen = false;
         
        for (int i = xIndex; i >= 0; i--) {
            if (aIndex > -1 && a[aIndex] > k) {
                b[i] = a[aIndex--];
            } else {
                if (!chen) {
                    b[i] = k;
                    chen = true;
                } else {
                    b[i] = a[aIndex--];
                }
            }
        }
        return b;
    }
     
    /**
     *   Hàm in các phần tử của mảng a
     *   @param a
     *   @return
     *   @throws     
     */
    public static void in(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


}
