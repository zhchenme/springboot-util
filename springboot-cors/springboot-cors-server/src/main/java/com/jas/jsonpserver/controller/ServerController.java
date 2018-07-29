package com.jas.jsonpserver.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author zc
 * @description
 * @create 2018-07-25 20:57
 **/

@RestController
public class ServerController {

    /**
     * 测试 GET 形式的请求
     * 
     * @return
     */
    @GetMapping("/gettest")
    public String getTest() {
        return "Hello Jas";
    }
    /**
     * 测试 POST 形式的请求
     * 
     * @return
     */
    @PostMapping("/posttest")
    public String postTest() {
        return "Hello Jas";
    }

    /**
     * 测试携带 Cookie 信息的请求
     * 
     * @param cookieValue
     * @return
     */
    @GetMapping("/cookietest")
    public String getCookie(@CookieValue(value = "cookie") String cookieValue) {
        return "获取到的 Cookie 值为：" + cookieValue;
    }

    /**
     * 测试携带自定义请求头的请求
     * 
     * @param headerValue
     * @return
     */
    @GetMapping("/headertest")
    public String getMyHeader(@RequestHeader("my-header") String headerValue) {
        return "获取到的 Header 信息为：" + headerValue;
    }
}
