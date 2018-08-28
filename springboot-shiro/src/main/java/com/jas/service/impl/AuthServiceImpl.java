package com.jas.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jas.entity.Auth;
import com.jas.exception.MyException;
import com.jas.mapper.AuthDao;
import com.jas.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author zchen
 * @since 2018-08-27
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthDao, Auth> implements AuthService {

    @Override
    public List<Auth> getUserAuthListById(Long id) {
        if (null == id) {
            throw new MyException("未知异常，请联系");
        }
        
        return super.baseMapper.getUserAuthListById(id);
    }
}
