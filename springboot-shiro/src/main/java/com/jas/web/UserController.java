package com.jas.web;


import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.common.ResponseEntity;
import com.jas.entity.User;
import com.jas.service.UserService;
import com.jas.status.StatusInfoEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
     * 安全退出
     *
     * @return
     */
    @GetMapping("/logout")
    private ResponseEntity<Boolean> logout() {
        ResponseEntity<Boolean> res = new ResponseEntity<>();
        Subject subject = SecurityUtils.getSubject();
        
        subject.logout();
        subject.getSession().removeAttribute("currentUser");
        res.setData(true);
        
        return res;
    }
    
    /**
     * 获取当前用户信息，测试用
     * 
     * @return
     */
    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        ResponseEntity<User> res = new ResponseEntity<>();
        User user = userService.getCurrentUser();
        res.setData(user);
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

