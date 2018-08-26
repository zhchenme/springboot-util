package com.jas.service.impl;

import com.jas.entity.Auth;
import com.jas.mapper.AuthDao;
import com.jas.service.AuthService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthDao, Auth> implements AuthService {

    @Override
    public List<Auth> getUserAuthListById(Long id) {
        return super.baseMapper.getUserAuthListById(id);
    }
}
