package com.tinhnd.day4day5.exception;

public class EmailException extends Exception{
    public EmailException(String s){  
        super(s);   // gọi non - parameter constructor của Exception để throws ra message trong exception 
       }  
}
