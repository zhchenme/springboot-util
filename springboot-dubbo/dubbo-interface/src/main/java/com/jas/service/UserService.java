/*
 * Copyright (C) 2009-2018 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.service;

import com.jas.bean.User;

/**
 * UserService
 *
 * @author lanxiang
 * @since 2018-12-02
 */
public interface UserService {
    /**
     * 根据用户 id 获取用户信息
     * 
     * @param userId id
     * @return 用户信息
     */
    User getUserInfoByUserId(String userId);
}
