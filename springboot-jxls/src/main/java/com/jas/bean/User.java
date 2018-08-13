package com.jas.bean;

import java.util.Date;

/**
 * @author zc
 * @description
 * @create 2018-08-12 16:16
 */
public class User {
    private String userName;
    
    private Integer age;
    
    private Date birth;

    public User(String userName, Integer age, Date birth) {
        this.userName = userName;
        this.age = age;
        this.birth = birth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
