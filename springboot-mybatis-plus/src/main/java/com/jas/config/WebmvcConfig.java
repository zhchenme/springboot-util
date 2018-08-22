package com.jas.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 管理 mvc
 * 
 * @author zc
 * @description
 * @create 2018-08-21 21:49
 */
@Configuration
public class WebmvcConfig implements WebMvcConfigurer{

    /**
     * 消息转换器
     * 
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        final ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        
        // JavaScript 无法处理 Java 的长整型 Long 导致精度丢失，解决办法 Long 转为 String 返回
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        
        // 时间格式转换
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
