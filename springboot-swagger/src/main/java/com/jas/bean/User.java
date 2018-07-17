package com.jas.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jas
 * @create 2018-07-17 21:38
 **/
public class User {
    @ApiModelProperty("用户 id")
    private Integer id;
    
    @ApiModelProperty("用户名")
    private String userName;
    
    @ApiModelProperty("用户密码")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
