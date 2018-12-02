/*
 * Copyright (C) 2009-2018 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jas.bean.User;
import com.jas.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author lanxiang
 * @since 2018-12-02
 */
@RestController
public class UserController {
    @Reference
    private UserService userService;
    
    @GetMapping("/user")
    public User getUserInfoById(@RequestParam("user_id") String userId) {
        return userService.getUserInfoByUserId(userId);
    }
}
