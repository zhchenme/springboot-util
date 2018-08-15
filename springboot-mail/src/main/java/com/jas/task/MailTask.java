package com.jas.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;

/**
 * @author zc
 * @description
 * @create 2018-08-15 21:08
 */
@Component
public class MailTask {
    
    @Autowired
    private JavaMailSenderImpl mailSender;

    /**
     * second, minute, hour, day, month, week
     * 特殊字符语法:, 枚举, - 区间, * 任意, / 步长, ? 日与星期冲突匹配, L 最后, W 工作日
     * 
     * @throws Exception
     */
    @Scheduled(cron = "0/10 * * * * MON-FRI")
    public void test() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("测试测试测测测");
        mimeMessageHelper.setText("<b style='color:red'>测试测试</b>", true);

        mimeMessageHelper.setTo("1012037464@qq.com");
        mimeMessageHelper.setFrom("coderjas@foxmail.com");

        mimeMessageHelper.addAttachment("1.jpg",
                ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/images/1.jpg"));

        mailSender.send(mimeMessage);
    }
}
