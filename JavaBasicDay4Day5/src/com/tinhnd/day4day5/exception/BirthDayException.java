package com.tinhnd.day4day5.exception;



public class BirthDayException extends Exception {
    public BirthDayException(String d){  
        super(d);   // gọi non - parameter constructor của Exception để throws ra message trong exception 
       }  
}
