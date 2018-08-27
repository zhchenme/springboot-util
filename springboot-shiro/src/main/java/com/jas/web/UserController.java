package com.jas.web;


import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.common.ResponseEntity;
import com.jas.entity.User;
import com.jas.service.UserService;
import com.jas.status.StatusInfoEnum;
import com.jas.vo.UserVo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户数据表 前端控制器
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

/*    *//**
     * 用户登录
     * 
     * @param userName
     * @param password
     * @return
     *//*
    @GetMapping("/login")
    public ResponseEntity<Boolean> userLogin(@RequestParam String userName, @RequestParam String password) {
        ResponseEntity<Boolean> res = new ResponseEntity<>();
        
        try {
            res.setData(userService.userLogin(userName, password));
        } catch (UnknownAccountException e) {
            res.statusInfo(StatusInfoEnum.REQUEST_USERNAMEORPASSWORD_EXCEPTION);
        } catch (IncorrectCredentialsException e) {
            res.statusInfo(StatusInfoEnum.REQUEST_USERNAMEORPASSWORD_EXCEPTION);
        }

        return res;
    }*/

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseEntity<Boolean> userLogin(@RequestParam String userName, @RequestParam String password) {
        ResponseEntity<Boolean> res = new ResponseEntity<>();
        Boolean b = userService.userLogin(userName, password);
        res.setData(b);
        
        if (false == b) {
            res.statusInfo(StatusInfoEnum.REQUEST_USERNAMEORPASSWORD_EXCEPTION);
        }
        
        return res;
    }
    
    /**
     * 未认证
     *
     * @return
     */
    @GetMapping("/unAuthc")
    private ResponseEntity<Boolean> unAuthc() {
        ResponseEntity<Boolean> res = new ResponseEntity<>();
        res.statusInfo(StatusInfoEnum.REQUEST_UNAUTHC_EXCEPTION);
        return res;
    }

    /**
     * 未授权
     *
     * @return
     */
    @GetMapping("/unPerms")
    private ResponseEntity<Boolean> unPerms() {
        ResponseEntity<Boolean> res = new ResponseEntity<>();
        res.statusInfo(StatusInfoEnum.REQUEST_UNPERMS_EXCEPTION);
        return res;
    }

    /**
     * 获取当前用户信息
     * 
     * @return
     */
    @GetMapping("/current")
    public ResponseEntity<UserVo> getCurrentUser() {
        ResponseEntity<UserVo> res = new ResponseEntity<>();
        UserVo userVo = userService.getCurrentUser();
        res.setData(userVo);
        return res;
    }
    
    /**
     * 分页获取所有用户信息
     * 
     * @param request
     * @return
     */
    @GetMapping("/page")
    public ResponseEntity<MyBasePageResponse<User>> listUserPage(MyBasePageRequest<User> request) {
        ResponseEntity<MyBasePageResponse<User>> res = new ResponseEntity<>();
        MyBasePageResponse<User> response = userService.listUserPage(request);
        res.setData(response);
        return res;
    }
}

