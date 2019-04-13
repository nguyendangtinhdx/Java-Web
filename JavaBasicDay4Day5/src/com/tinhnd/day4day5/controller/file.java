package com.tinhnd.day4day5.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class file {

    private static final Logger log = Logger.getLogger( "./TestLog.txt");
      
          public static void main(String[] args) throws Exception
          {
   
            log.debug("Debug   Message");
            log.warn ("Warning Message");
            log.error("Error   Message");
            log.info("aaaaaaaa");
     
             LogManager.shutdown();
         }

}
