package com.jas.service.impl;

import com.jas.entity.User;
import com.jas.mapper.UserDao;
import com.jas.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户数据表 服务实现类
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
