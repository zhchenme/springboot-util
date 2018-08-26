package com.jas;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jas.entity.User;
import com.jas.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zchen
 * @description
 * @create 2018-08-26 14:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void getUser() {
        List<User> userList = userService.selectList(new EntityWrapper<>());

        for (int i = 0; i < userList.size(); i++) {
            User user =  userList.get(i);

            System.out.println(user.getUserName());
        }
    }
}
