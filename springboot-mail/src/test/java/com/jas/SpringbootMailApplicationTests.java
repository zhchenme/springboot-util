package com.jas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {

    @Autowired
    private JavaMailSenderImpl mailSender;
    
    /**
     * 测试简单邮件
     */
    @Test
	public void simpleMailMessageTest() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setSubject("测试测试测测测");
		mailMessage.setText("测试测试");
		
		mailMessage.setTo("1012037464@qq.com");
		mailMessage.setFrom("coderjas@foxmail.com");
		
		mailSender.send(mailMessage);
	}

    /**
     * 发送邮件并携带附件
     * 
     * @throws Exception
     */
	@Test
	public void mimeMessageHelperTest() throws Exception {
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
