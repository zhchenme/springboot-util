package com.jas.service.impl;

import com.jas.entity.RoleAuth;
import com.jas.mapper.RoleAuthDao;
import com.jas.service.RoleAuthService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-权限关联表 服务实现类
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthDao, RoleAuth> implements RoleAuthService {

}
