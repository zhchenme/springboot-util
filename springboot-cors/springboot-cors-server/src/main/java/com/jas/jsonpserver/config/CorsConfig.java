package com.jas.jsonpserver.config;

import com.jas.jsonpserver.filter.MyCorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author zc
 * @description 跨域的两种实现方式
 * @create 2018-07-26 21:36
 **/
@Configuration
public class CorsConfig {
    private static final String ORIGIN = "Origin";
    private static final String HEADERS = "Access-Control-Request-Headers";
    
    /**
     * 1.通过设置自定义 CorsFilter 过滤器支持跨域
     * @return
     */
    @Bean
    public MyCorsFilter injectCorsFilter() {
        return new MyCorsFilter();
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        // 设置支持带 Cookie 的跨域请求
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*"); 
        // 设置非简单请求的预检命令缓存时间，单位 's'
        corsConfiguration.setMaxAge(1728000L);
        
        return corsConfiguration;
    }

    /**
     * 2.自定义 CORS 配置信息，并注入到 CorsFilter 过滤器中
     * 
     * @return
     */
//    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}