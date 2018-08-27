package com.jas.common.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jas.exception.MyException;
import com.jas.status.StatusInfoEnum;
import com.jas.vo.UserVo;
import org.apache.shiro.SecurityUtils;

/**
 * @author zchen
 * @description service 层超类
 * @create 2018-08-27 15:24
 */
public class SuperService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    /**
     * 获取当前用户
     *
     * @return user对象
     */
    public UserVo getCurrentUser() {
        UserVo userVo = (UserVo) SecurityUtils.getSubject().getPrincipal();
        
        if (userVo == null) {
            throw new MyException(StatusInfoEnum.REQUEST_UNAUTHC_EXCEPTION);
        }
        
        return userVo;
    }
}
