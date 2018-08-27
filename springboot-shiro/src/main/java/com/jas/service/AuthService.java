package com.jas.service;

import com.jas.entity.Auth;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 用户权限表 服务类
 * </p>
 *
 * @author zchen
 * @since 2018-08-27
 */
public interface AuthService extends IService<Auth> {

    /**
     * 根据用户 id 获取权限
     * 
     * @param id
     * @return
     */
    List<Auth> getUserAuthListById(Long id);
}
