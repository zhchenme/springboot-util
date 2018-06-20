package com.jas.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jas
 * @create 2018-06-20 13:46
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public String handlexception(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(16);
        
        map.put("code", 0);
        map.put("message", "出异常啦");
        
        // 设置异常处理的状态码为 404
        request.setAttribute("javax.servlet.error.status_code", 404);
        // 将错误信息封装成 map 保存在转发域中
        request.setAttribute("myErrorInfo", map);
        
        // 出现异常时转发到 'error' 请求，跳转到 40 页面
        return "forward:/error";
    }
}
