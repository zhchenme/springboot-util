package com.jas.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jas
 * @create 2018-02-19 16:08
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ResponseBody
    @ExceptionHandler
    private Map<String, Object> exceptionHandler(Exception e){
        Map<String, Object> modelMap = new HashMap<>();
        
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        
        return modelMap;
    }
}
