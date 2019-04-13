package com.tinhnd.day6.controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 * @author nguye
 *
 */
public abstract class fileLog {
    private static final Logger logger = Logger.getLogger(fileLog.class.getName());
    public static void main(String[] args) {
//        ghiFileLog("333333333333333333");
    }
    public static void ghiFileLog(String content)
    {
        Handler fh = null;
        try {
            fh = new FileHandler("./InfoLog.log", true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
       logger.addHandler(fh);
        logger.setLevel(Level.ALL);
   
        try {
           throw new Exception(content);
        } catch (Exception ex){
        }
        logger.info(content);
   

        fh.flush();
        fh.close();
    }
}
