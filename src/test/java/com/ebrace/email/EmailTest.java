package com.ebrace.email;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class EmailTest {
//    @Autowired
//    private JavaMailSender mailSender; //自动注入的Bean
//
//    @Value("${spring.mail.username}")
//    private String Sender; //读取配置文件中的参数
//    
//    @Test
//    public void sendHtmlMail() {
//        MimeMessage message = null;
//        try {
//            message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(Sender);
//            helper.setTo(Sender);
//            helper.setSubject("标题：发送Html内容");
//
//            StringBuffer sb = new StringBuffer();
//            sb.append("<h1>大标题-h1</h1>")
//                    .append("<p style='color:#F00'>红色字</p>")
//                    .append("<p style='text-align:right'>右对齐</p>");
//            helper.setText(sb.toString(), true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mailSender.send(message);
//    }

}
