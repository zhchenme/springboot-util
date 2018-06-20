package com.jas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jas
 * @create 2018-06-20 21:02
 **/
@Controller
public class TestController {
    
    @GetMapping("/hello")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("username", "张三");
        return modelAndView;
    }
}
