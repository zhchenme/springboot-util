package com.jas.exception;

import com.jas.common.ResponseEntity;
import com.jas.status.StatusInfoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常处理，使用日志打印异常信息
 * </p>
 *
 * @author zchen
 * @create 2018-08-30 15:43
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 运行时异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?>  runtimeExceptionHandler(Exception e) {
        ResponseEntity<Boolean> res = new ResponseEntity<>(StatusInfoEnum.BUSINESS_FAILURE.getCode(),
                StatusInfoEnum.BUSINESS_FAILURE.getMessage());
        log.error("runtime exception" + " >_> " + e.getMessage(), e);
        return res;
    }

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<?> myExceptionHandler(MyException e) {
        ResponseEntity<Boolean> res = new ResponseEntity<>(e.getErrorCode(), e.getMessage());
        log.error("customize exception" + " >_> " + e.getMessage(), e);
        return res;
    }

    /**
     * 前端参数异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMessageConversionException.class)
    public ResponseEntity<?> argumentErrorHandler(HttpMessageConversionException e) {
        ResponseEntity<String> res = new ResponseEntity<>(StatusInfoEnum.BUSINESS_FAILURE.getCode(), 
                StatusInfoEnum.BUSINESS_FAILURE.getMessage());
        log.error("message conversion exception" + " >_> " + e.getMessage(), e);
        return res;
    }

//    /**
//     * 异常信息获取
//     *
//     * @param t
//     * @return
//     */
//    public static String printStackTraceToString(Throwable t) {
//        StringWriter sw = new StringWriter();
//        t.printStackTrace(new PrintWriter(sw, true));
//        return sw.getBuffer().toString();
//    }
}
