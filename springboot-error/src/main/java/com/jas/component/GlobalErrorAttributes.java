package com.jas.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author Jas
 * @create 2018-06-20 14:17
 **/
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes{

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        // 获取异常处理中的错误信息，'0' 表示从转发域中获取
        Map<String, Object> myErrorMap = (Map<String, Object>) webRequest.getAttribute("myErrorInfo", 0);
        
        // 模板页面，JSON 都可以获取
        map.put("test", "测试信息");
        // 模板页面不能获取，JSON 可以
        map.put("myErrorInfo", myErrorMap);
        
        return map;
    }
}
