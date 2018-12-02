/*
 * Copyright (C) 2009-2018 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jas.bean.User;
import com.jas.service.UserService;

/**
 * UserServiceImpl
 *
 * @author lanxiang
 * @since 2018-12-02
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserInfoByUserId(String userId) {
        return getUserInfo(Long.valueOf(userId));
    }

    /**
     * 模拟获取数据
     * 
     * @param userId 用户 id
     * @return 用户信息
     */
    public User getUserInfo(long userId) {
        return new User(userId, "Jas", "HangZhou");
    }
}
