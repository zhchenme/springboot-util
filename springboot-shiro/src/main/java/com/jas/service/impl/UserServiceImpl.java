package com.jas.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.common.service.SuperService;
import com.jas.entity.User;
import com.jas.exception.MyException;
import com.jas.mapper.UserDao;
import com.jas.service.UserService;
import com.jas.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户数据表 服务实现类
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@Service
public class UserServiceImpl extends SuperService<UserDao, User> implements UserService{
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public Boolean userLogin(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return false;
        }catch (IncorrectCredentialsException e) {
            return false;
        }
        
        return true;
    }

    @Override
    public UserVo getCurrentUser() {
        UserVo currentUser = super.getCurrentUser();
        
        return currentUser;
    }

    @Override
    public MyBasePageResponse<User> listUserPage(MyBasePageRequest<User> request) {
        request.setAscs(Arrays.asList("id"));

        // 分页获取所有用户信息
        List<User> userList = super.baseMapper.selectPage(request.getPagePlus(), new EntityWrapper<>(null));

        if (userList.isEmpty()) {
            throw new MyException("用户数据为空，请稍后尝试");
        }
        
        // 设置结果集
        request.getPagePlus().setRecords(userList);
        
        return new MyBasePageResponse<>(request.getPagePlus());
    }
}
