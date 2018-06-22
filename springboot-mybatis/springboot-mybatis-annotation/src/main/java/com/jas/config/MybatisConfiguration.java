package com.jas.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jas
 * @create 2018-06-22 9:38
 **/
@MapperScan(basePackages = {"com.jas.mapper"})
@Configuration
public class MybatisConfiguration {

    /**
     * 自定义 MyBatis 的配置规则
     * 开启驼峰命名
     * 
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
