
# springboot-study

## springboot-chart
柱状图、条形图、饼图数据封装的简单。在做一些报表统计时如果涉及到图表，可以参考这个 demo。

参考 [xwjie](https://github.com/xwjie/SpringBootEChart) 的开源代码，修改了一部分，方便以后用到项目中去。
效果图
![avatar](springboot-chart/images/2.png)

## springboot-cors

Spring Boot 结合 CORS 在服务端解决 AJAX 跨域问题的 demo。

1.使用 <code>CorsConfiguration</code> 配置
```java
@Configuration
public class CorsConfig {
    private static final String ORIGIN = "Origin";
    private static final String HEADERS = "Access-Control-Request-Headers";
    
    /**
     * 通过设置自定义 CorsFilter 过滤器支持跨域
     *
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
}
```
2.使用过滤器配置
```java
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
```

## springboot

实现了 SpringBoot + MyBatis 搭建的小程序。<code>areadisplay </code> 中包含了小程序所需要的代码，<code>t_area.sql </code> 是数据库导出的结构文件，<code>src </code> 目录下为主要的后端代码。

## springboot-error

Spring Boot 异常与错误处理的（404、500...） demo。Spring Boot 可以根据 HTTP 的请求头（<code>accept</code>）信息，判断客户端想要什么类型的返回数据（HTML OR JSON），可以在 <code>BasicErrorController</code> 类中查看。

在有模板引擎的情况下，Spring Boot 底层会扫描 <code>templates/error/×××.html</code> 页面，根据 HTTP 的响应码找到对应的错误提示页面，在该页面下也可以通过表达式获取一些错误提示信息。如果没有配置模板引擎，则扫描 <code>static/error/×××.html</code> 页面。

这个 demo 对异常与错误进行了整合，当出现异常与 404 错误时，用浏览器访问会跳转到 <code>templates/error/404.html</code> 页面，其他客户端访问时会返回内置与自定义的 JSON 数据。

## springboot-jsp

Spring Boot 整合 JSP 开发的 demo，基于 Spring Boot2.0 以上版本，使用本地 tomcat 容器。需要注意的是，本地 tomcat 容器版本必须支持 Spring Boot 的版本，否则启动 tomcat 时会报错。 

demo 基于 Spring Boot2.03、Tomcat-8.5.31


## springboot-mybatis

整合了基于注解与配置文件两种方式的 demo，使用阿里开源的数据源 <code>druid</code>，并配置了监控中心。

## springboot-swagger

Spring Boot 整合 Swagger API 构建工具，提供可视化的 UI 文档界面，便于前后端交互。

## springboot-jxls

Spring Boot 整合 jxls 实现 Excel 文档的导出与下载。

## springboot-mail

Spring Boot 整合邮件开发，定时任务。

## springboot-mybatis-plus 

Spring Boot 整合 MyBatis Plus 的企业级 demo。

采用前后端分离的方式，在后端使用通用的实体返回 JSON 数据，包括枚举的使用、统一分页请求与响应实体类、自定义异常与异常处理等。
