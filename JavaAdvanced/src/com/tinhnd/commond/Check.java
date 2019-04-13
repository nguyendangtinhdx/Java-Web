package com.tinhnd.commond;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Check
 * 
 * Version 1.0
 * 
 * Date 31-1-2018
 * 
 * Copyright
 * 
 * Modification logs DATE AUTHOR DESCRIPTION
 * ------------------------------------------------ 31-1-2018 TỉnhND Create
 *
 */
public class Check {
    /**
     * Hàm  kiểm tính hợp lệ số điện thoại
     * @param sdtPhone
     * @return 
     * @throws
     */
    public boolean checkPhone(String sdtPhone) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(sdtPhone);
        if (!matcher.matches()) {
            return false;
        } else if (sdtPhone.length() == 9 || sdtPhone.length() == 10) {
            if (sdtPhone.length() == 9) {
                if (sdtPhone.substring(0, 1).equals("9")) {
                    return true;
                } else {
                    return false;
                }
            } else if (sdtPhone.substring(0, 1).equals("1")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     * Hàm  kiểm tính hợp lệ email
     * @param email
     * @return 
     * @throws
     */
    public  boolean checkEmail(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Hàm  kiểm tính hợp lệ giờ
     * @param hour
     * @return 
     * @throws
     */
    public boolean checkHour(String hour) {
        String s[] = hour.split("[:]");
        if(Integer.parseInt(s[0]) >= 24 || Integer.parseInt(s[0]) < 0) {
            return false;
        }
//        if((s[0].charAt(0) < 0 || s[0].charAt(0) > 2) && (s[0].charAt(1) < 0 || s[0].charAt(1) > 3)) {
//            return false;
//        }
        if(Integer.parseInt(s[1]) >= 60 || Integer.parseInt(s[1]) < 0) {
            return false;
        }
//        if((s[1].charAt(0) < 0 || s[1].charAt(0) > 5) && (s[1].charAt(1) < 0 || s[1].charAt(1) > 9)){
//            return false;
//        }
        return true;
    }
}
