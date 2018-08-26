package com.jas.mapper;

import com.jas.entity.Auth;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户权限表 Mapper 接口
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
public interface AuthDao extends BaseMapper<Auth> {

    /**
     * 根据用户 id 获取权限信息
     * 
     * @param id
     * @return
     */
    List<Auth> getUserAuthListById(Long id);
}
