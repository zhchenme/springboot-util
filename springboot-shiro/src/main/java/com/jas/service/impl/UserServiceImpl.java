package com.jas.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.common.service.SuperService;
import com.jas.entity.User;
import com.jas.exception.MyException;
import com.jas.mapper.UserDao;
import com.jas.service.UserRoleService;
import com.jas.service.UserService;
import com.jas.status.AuthorizationEnum;
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

    private static final Logger logger = LoggerFactory.getLogger(UserRoleService.class);

    @Override
    public Boolean userLogin(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);

            /**
             * 模拟授权操作
             */
            if (subject.isPermitted(AuthorizationEnum.MANAGER_ALL.getCode())) {
                logger.info("当前是管理员，拥有所有权限");
            } else if (subject.isPermitted(AuthorizationEnum.USER_SELECT.getCode())) {
                logger.info("当前是普通用户，拥有只读权限");
            }
        } catch (UnknownAccountException e) {
            return false;
        } catch (IncorrectCredentialsException e) {
            return false;
        }

        return true;
    }

    @Override
    public User getCurrentUser() {
        User currentUser = super.getCurrentUser();

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
