package com.tinhnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tinhnd.service.HelloWorldService;

@Controller
@RequestMapping(value="/")
public class HelloWorld {
    @Autowired
    private HelloWorldService helloWorldService;
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("welcomePage", "welcomeMessage", helloWorldService.welcomeMessage());
    }
    
    @RequestMapping(value="welcomeAgain",method=RequestMethod.GET)
    public ModelAndView welcomeAgain() {
        return new ModelAndView("welcomePage", "welcomeMessage", helloWorldService.welcomeAgainMessage());
    }
}
