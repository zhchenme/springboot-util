/*
 * Copyright (C) 2009-2018 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * User
 *
 * @author lanxiang
 * @since 2018-12-02
 */
@Data
@AllArgsConstructor
public class User implements Serializable{
    private static final long serialVersionUID = -4373733289848254727L;
    private Long userId;
    
    private String userName;
    
    private String address;
}
