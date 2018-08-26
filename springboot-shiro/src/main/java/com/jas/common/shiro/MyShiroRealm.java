package com.jas.common.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jas.entity.Auth;
import com.jas.entity.User;
import com.jas.service.AuthService;
import com.jas.service.UserService;
import com.jas.vo.UserVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.security.Permissions;
import java.util.List;

/**
 * @author zchen
 * @description 自定义 realm
 * @create 2018-08-24 17:41
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthService authService;

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

        // 判断用户是否存在
        if (StringUtils.isEmpty(userName)) {
            return null;
        }

        // 获取用户名
        List<User> userList = userService.selectList(new EntityWrapper<User>().eq("user_name", userName));

        if (null == userList || userList.isEmpty()) {
            return null;
        }

        User user = userList.get(0);

        // 注入凭证校验,userName 作为盐
        ByteSource salt = ByteSource.Util.bytes(user.getUserName());

        // 注入凭证匹配器.进行 md5 校验
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());

        return authcInfo;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 缓存中取用户信息
        User user = (User) principals.getPrimaryPrincipal();
        UserVo userVo = new UserVo();

        userVo.setId(user.getId());
        userVo.setUserName(user.getUserName());
        userVo.setPassword(user.getPassword());

        // 查询权限
        List<Auth> authList = authService.getUserAuthListById(user.getId());

        userVo.setAuthList(authList);

        // 构造权限后返回
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 构造权限
        for (Auth auth : authList) {
            info.addStringPermission(auth.getAuthName());
        }

        return info;
    }

}
