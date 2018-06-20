
# springboot-study

## springboot

实现了 SpringBoot + MyBatis 搭建的小程序。<code>areadisplay </code>中包含了小程序所需要的代码，<code>t_area.sql </code>是数据库导出的结构文件，<code>src </code> 目录下为主要的后端代码。

## springboot-error

Spring Boot 异常与错误处理的（404、500...） demo。Spring Boot可以根据 HTTP 的请求头（<code>accept</code>）信息，判断客户端想要什么类型的返回数据（HTML OR JSON）。

在有模板引擎的情况下，Spring Boot 底层会扫描 templates/error/×××.html 页面，根据 HTTP 的响应码找到对应的错误提示页面，在该页面下也可以通过表达式获取一些错误提示信息。如果没有配置模板引擎，则扫描 static/error/×××.html 页面。

这个 demo 对异常与错误进行了整合，当出现异常与 404 错误时，用浏览器访问会跳转到 templates/error/404.html 页面，其他客户端访问时会返回内置与自定义的 JSON 数据。

浏览器测试：<br>
<img src="https://s1.ax1x.com/2018/06/20/Cz7IeJ.png" alt="" width="450" height="166">
postman 测试：<br>
<img src="https://s1.ax1x.com/2018/06/20/Cz7tit.png" alt="" width="450" height="166">
