package com.jas.vo;

import com.jas.entity.Auth;
import com.jas.entity.User;

import java.util.List;

/**
 * @author zchen
 * @description 用户信息 vo
 * @create 2018-08-26 21:11
 */
public class UserVo extends User {
    /**
     * 用户权限
     */
    private List<Auth> authList;

    public List<Auth> getAuthList() {
        return authList;
    }

    public void setAuthList(List<Auth> authList) {
        this.authList = authList;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "authList=" + authList +
                '}';
    }
}
