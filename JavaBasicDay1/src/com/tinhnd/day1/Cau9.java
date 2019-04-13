package com.tinhnd.day1;

import java.util.Scanner;
/**
* Cau9. Viết chương trình thực hiện công việc sau: a. Nhập ma trận A (m dòng,
     * n cột) gồm các phần tử kiểu int b. Tính tích các số là bội số của 3 nằm
     * trên dòng đầu tiên của ma trận c. Tạo ra mảng một chiều X với X[i] là các
     * giá trị lớn nhất trên từng dòng i của ma trận A.
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
public class Cau9 {
    
    /**
     *   main
     *   @param args
     *   @return 
     *   @throws     
     */
    public static void main(String[] args) {
        int[][] a;
        int[] c;
        int m, n;

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số dòng và cột, m, n: ");
        m = sc.nextInt();
        n = sc.nextInt();
        a = nhap(m, n);
        System.out.println("Ma trận A: ");
        in(a);
        System.out.println(
                "Tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận =  "
                        + tich(a, m, n));
        System.out.println("Ma trận giá trị lớn nhất mỗi dòng của ma trận A là: ");
        c = new int[m];
        max(c, a, m, n);
        xuatMang1Chieu(c, m);
    }
    
    /**
     *   Hàm tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận
     *   @param a,m,n
     *   @return p
     *   @throws     
     */
    private static int tich(int a[][], int m, int n) {
        int p = 1;
        for (int i = 0; i < 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[i][j] % 3 == 0)
                    p *= a[i][j];
            }
        }
        return p;
    }
    
    /**
     *    Hàm tính giá trị lớn nhất mỗi dòng của ma trận 
     *   @param c,a,m,n
     *   @return Max
     *   @throws     
     */
    
    private static void max(int c[], int a[][], int m, int n) {
        int max = a[0][0];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                    if (a[i][j] > max) {
                        c[i] = a[i][j];
                    }
            }
        }
    }

    /**
     *    Hàm nhập ma trận
     *   @param m,n
     *   @return result
     *   @throws     
     */
    static int[][] nhap(int m, int n) {
        int[][] result = new int[m][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("a[" + i + "][" + j + "]= ");
                result[i][j] = sc.nextInt();
            }
        }
        return result;
    }
    
    /**
     *    Hàm in ma trận
     *   @param a
     *   @return 
     *   @throws     
     */
    static void in(int[][] a) {
        for (int[] x : a) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
    }
    /**
     *    Hàm xuất mảng 1 chiều
     *   @param a , m
     *   @return 
     *   @throws     
     */
    static void xuatMang1Chieu(int[] a, int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
