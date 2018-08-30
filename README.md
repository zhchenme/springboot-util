
# springboot-study

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

## springboot-cors

Spring Boot 在服务端解决 AJAX 跨域问题的 demo。

## springboot-swagger

Spring Boot 整合 Swagger API 构建工具，提供可视化的 UI 文档界面，便于前后端交互。

## springboot-jxls

Spring Boot 整合 jxls 实现 Excel 文档的导出与下载。

## springboot-mail

Spring Boot 整合邮件开发，定时任务。

## springboot-mybatis-plus 

Spring Boot 整合 MyBatis Plus 的企业级 demo。

采用前后端分离的方式，在后端使用通用的实体返回 JSON 数据，包括枚举的使用、统一分页请求与响应实体类、自定义异常与异常处理等。
