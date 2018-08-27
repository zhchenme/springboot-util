package com.jas.service;

import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.jas.vo.UserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户数据表 服务类
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * 
     * @param userName
     * @param password
     * @return
     */
    Boolean userLogin(String userName, String password);

    /**
     * 获取当前用户
     * 
     * @return
     */
    UserVo getCurrentUser();
    
    /**
     * 获取所有用户信息
     * 
     * @param request
     * @return
     */
    MyBasePageResponse<User> listUserPage(MyBasePageRequest<User> request);

}
