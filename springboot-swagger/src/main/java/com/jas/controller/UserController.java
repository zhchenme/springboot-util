package com.jas.controller;

import com.jas.bean.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jas
 * @create 2018-07-17 21:40
 **/

@Controller
public class UserController {
    
    @ResponseBody
    @GetMapping("/user/{id}")
    @ApiOperation(value = "swagger 测试，根据 id 获取用户信息", httpMethod = "GET", response = User.class)
    public User testSwagger(@PathVariable Integer id) {
        User user = getUserById(id);
        
        return user;
    }
    
    public User getUserById(Integer id) {
        User user = new User();
        
        user.setId(1);
        user.setUserName("jas");
        user.setPassword("123456");
        
        return user;
    }
}
