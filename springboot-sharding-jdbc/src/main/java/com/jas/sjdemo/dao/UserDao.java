package com.jas.sjdemo.dao;

import com.jas.sjdemo.entity.User;

import java.util.List;

public interface UserDao  {
    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/3/25 14:22
     * @param user user
     */
    void addOne(User user);

    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/3/25 14:22
     * @param id id
     * @return com.fanxb.sjdemo.entity.User
     */
    User getOneById(long id);

    List<User> selectList(String name);
}
