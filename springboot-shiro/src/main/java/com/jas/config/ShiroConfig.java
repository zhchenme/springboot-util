package com.jas.config;

import com.jas.common.shiro.MyShiroRealm;
import com.jas.common.shiro.ShiroLoginFilter;
import com.jas.common.shiro.ShiroPermsFilter;
import com.jas.common.shiro.ShiroSessionManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zchen
 * @description shiro 配置类
 * @create 2018-08-24 17:07
 */
@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * shiro 拦截器拦截到所有请求后，调用此方法
     *
     * @param manager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();

        factory.setSecurityManager(manager);

        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();

        filtersMap.put("ShiroLoginFilter", shiroLoginFilter());
        filtersMap.put("ShiroPermsFilter", shiroPermsFilter());

        factory.setFilters(filtersMap);

        // 设置过滤链
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        
        filterChainMap.put("/user/login", "anon");
        filterChainMap.put("/user/logout", "anon");
        filterChainMap.put("/user/**", "authc");
        
        factory.setFilterChainDefinitionMap(filterChainMap);
        
        // 没有认证用户,shiro 会跳转到登录页面,前后端分离项目后端不控制跳转,跳转到未授权界面,返回 json
        factory.setLoginUrl("/user/unAuthc");
        factory.setUnauthorizedUrl("/user/unPerms");
        
        return factory;
    }

    /**
     * 安全管理器
     * 
     * @param realm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(MyShiroRealm realm) {
        DefaultWebSecurityManager serurityManeger = new DefaultWebSecurityManager(realm);
        
        // 自定义缓存实现
        serurityManeger.setCacheManager(cacheManager());
        // 自定义 session 管理
        serurityManeger.setSessionManager(sessionManager());
        
        return serurityManeger;
    }

    /**
     * Session Manager 使用的是 shiro-redis 开源插件
     * 
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        ShiroSessionManager sessionManager = new ShiroSessionManager();
        
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setGlobalSessionTimeout(30 * 24 * 60 * 60 * 1000);

        return sessionManager;
    }

    /**
     * 配置 shiro redisManager 使用的是shiro-redis开源插件
     *
     * @return
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();

        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setPassword(password);
        // 配置缓存过期时间
        redisManager.setExpire(30 * 24 * 60 * 60);
        redisManager.setTimeout(timeout);

        return redisManager;
    }

    /**
     * cacheManager 缓存，使用的是 shiro-redis 开源插件
     *
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    /**
     * shiro sessionDao 层的实现
     *
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 自定义 Realm
     * 
     * @param credentialsMatcher
     * @return
     */
    @Bean
    public MyShiroRealm customRealm(HashedCredentialsMatcher credentialsMatcher) {
        MyShiroRealm realm = new MyShiroRealm();
        // 注入凭证匹配器
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    /**
     * 自定义认证拦截器
     *
     * @return
     */
    @Bean
    public ShiroLoginFilter shiroLoginFilter() {
        ShiroLoginFilter advice = new ShiroLoginFilter();
        return advice;
    }

    /**
     * 自定义授权拦截器
     *
     * @return
     */
    @Bean
    public ShiroPermsFilter shiroPermsFilter() {
        ShiroPermsFilter advice = new ShiroPermsFilter();
        return advice;
    }

    /**
     * 自定义凭证校验
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();

        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);

        return matcher;
    }

    /**
     *  shiro 注解拦截器
     *
     * @param securityManager
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

//    /**
//     * shiro记住我cookie管理
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {
//        CookieRememberMeManager re = new CookieRememberMeManager();
//        re.setCookie(rememberMeCookie);
//        return re;
//    }
//
//    @Bean
//    public SimpleCookie rememberMeCookie() {
//        SimpleCookie rememberMeCookie = new SimpleCookie();
//        
//        rememberMeCookie.setMaxAge(3600);
//        rememberMeCookie.setName("rememberMe");
//        
//        return rememberMeCookie;
//    }
    
}
