package com.jas.jsonpserver.filter;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zc
 * @description 使用自定义过滤器解决跨域问题
 * @create 2018-07-26 21:29
 **/
public class MyCorsFilter extends OncePerRequestFilter {
    private static final String ORIGIN = "Origin";
    private static final String HEADERS = "Access-Control-Request-Headers";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
            throws ServletException, IOException {
        // 获取请求头中的 'Origin' 信息
        String origin = request.getHeader(ORIGIN);
        // 获取请求头中的 'header' 信息
        String headers = request.getHeader(HEADERS);
        
        /**
         * 1.支持任何域名跨域访问
         * 当 'Access-Control-Allow-Origin' 设置为 '*' 时，不能解决带 Cookie 的跨域
         */
        if (!StringUtils.isEmpty(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }

        /**
         * 2.支持自定义请求头的跨域
         */
        if (!StringUtils.isEmpty(headers)) {
            response.setHeader("Access-Control-Allow-Headers", headers);
        }
        
        // 3.设置支持带 Cookie 的跨域请求
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 4.设置允许跨域请求的方法形式 'GET'、'DELETE' 等
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 5.设置非简单请求的预检命令缓存时间，单位 's'
        response.setHeader("Access-Control-Max-Age", "1728000");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
            
    }
}
