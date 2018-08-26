package com.jas.service.impl;

import com.jas.entity.UserRole;
import com.jas.mapper.UserRoleDao;
import com.jas.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色中间表 服务实现类
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}
