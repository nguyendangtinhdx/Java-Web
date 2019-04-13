package com.tinhnd.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String welcomeMessage() {
        return "Chào Tỉnh Bi";
    }

    public Object welcomeAgainMessage() {
        return "Hello Anh Tỉnh Again";
    }
}
