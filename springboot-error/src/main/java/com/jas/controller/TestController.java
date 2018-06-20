package com.jas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jas
 * @create 2018-06-20 8:49
 **/
@Controller
public class TestController {
    
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        int i = 1 / 0;
        return "Hello Spring Boot!";
    }
}
