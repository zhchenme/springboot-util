package com.jas.controller;

import com.jas.annotation.UserId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxiang
 * @since 2019/10/16
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public void testController(@UserId String userId) {
        System.out.println(userId);
    }

}
