package com.tinhnd.day1;

import java.io.IOException;

/**
* Cau11.Ví dụ để phân biệt khái niệm by pass value và by pass refference
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
public class Cau11 {
    /**
     *   main
     *   @param args
     *   @return 
     *   @throws 
     */
    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        foo(aDog);
        aDog.getName().equals("Max"); // by pass value
        aDog.getName().equals("Fifi"); // false 
    }
    /**
     *   Hàm foo
     *   @param d
     *   @return 
     *   @throws 
     */
    public static void foo(Dog d) {
        d.getName().equals("Max"); // true
        // thay đổi d bên trong foo() để trỏ đến một cá thể chó mới "Fifi"
        d = new Dog("Fifi");
        d.getName().equals("Fifi"); // true
    }
}
