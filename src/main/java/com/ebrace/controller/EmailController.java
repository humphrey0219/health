package com.ebrace.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.ebrace.exception.EbraceException;
import com.ebrace.util.RestResult;
import com.ebrace.util.ResultUtil;

import freemarker.template.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "EmailController", description = "email 模板程序")
@RestController
public class EmailController {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;  //自动注入
	
	@Value("${spring.mail.username}")
	private String sender; //读取配置文件中的参数
	    
	/**
	 * 此bug值得分享
	 * @param email
	 * @return
	 * @throws EbraceException
	 */
	@ApiOperation(value="发送html格式邮件", notes="发送html格式邮件，邮件中包含html内容")
	@GetMapping("/htmlmail/{email:.+}")
	public RestResult<?> sendHtmlMail(@PathVariable("email") String email)throws EbraceException {
		log.info("========================={}",email);
		MimeMessage message = null;
	    try{
	        message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(sender);
	        helper.setTo("lljit@qq.com");
	        helper.setTo(email);
	        helper.setSubject("标题：发送Html内容");

	        StringBuffer sb = new StringBuffer();
	        sb.append("<h1>大标题-h1</h1>")
	             .append("<p style='color:#F00'>红色字</p>")
	             .append("<p style='text-align:right'>右对齐</p>");
	        helper.setText(sb.toString(), true);
	        } catch (Exception e) {
	            log.info(e.toString());
	        }
	        mailSender.send(message);
	        return ResultUtil.success("send Html email by leealigner@qq.com");
	}
	
	/**
	 * 简单邮件发送demo
	 * @return
	 * @throws EbraceException
	 */
	@ApiOperation(value="发送简单邮件", notes="发送简单邮件，不包含任何格式")
	@GetMapping("/mail/{email:.+}")
	public RestResult<?> sendmail(@PathVariable("email") String email)throws EbraceException {
		log.info("========================={}",email);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("leealigner@qq.com");
		String[] receive={"leealigner@qq.com",email};
		message.setTo(receive);
//		message.setTo({"lljit@qq.com","it_train@qq.com"});
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);		
		return ResultUtil.success("send email by leealigner@qq.com");

	}
	
	@ApiOperation(value="发送附件邮件", notes="发送带附件的邮件")
	@GetMapping("/picturemail/{email:.+}")
	public RestResult<?> sendAttachmentsMail(@PathVariable("email") String email) {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(email);
            helper.setSubject("主题：带附件的邮件");
            helper.setText("带附件的邮件内容");
            //注意项目路径问题，自动补用项目路径
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/88p.jpg"));
            //加入邮件
            helper.addAttachment("图片.jpg", file);
        } catch (Exception e){
            log.error(e.toString());
        }
        mailSender.send(message);
        return ResultUtil.success("send email picture by leealigner@qq.com");
    }
	@ApiOperation(value="发送静态资源邮件", notes="发送带有静态资源的邮件")
	@GetMapping("/inlinemail/{email:.+}")
	public RestResult<?> sendInlineMail(@PathVariable("email") String email) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(email);
            helper.setSubject("主题：带静态资源的邮件");
            //第二个参数指定发送的是HTML格式,同时cid:是固定的写法
            helper.setText("<html><body>带静态资源的邮件内容 图片:<img src='cid:picture' /></body></html>", true);

            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/88p.jpg"));
            helper.addInline("picture",file);
        } catch (Exception e){
            log.error(e.toString());
        }
        mailSender.send(message);
        return ResultUtil.success("send email picture by leealigner@qq.com");
    }
	
	@ApiOperation(value="发送模板邮件", notes="发送模板邮件，demo程序")
	@GetMapping("/templatemail/{email:.+}")
	public RestResult<?> sendTemplateMail(@PathVariable("email") String email){
        MimeMessage message = null;
        log.info("========================={}",email);
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
    
            helper.setTo(email);
            helper.setSubject("主题：模板邮件");

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("username", "李四");

            //修改 application.properties 文件中的读取路径
//            FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//            configurer.setTemplateLoaderPath("classpath:templates");
            //读取 html 模板
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
        } catch (Exception e) {
            log.error(e.toString());
        }
        mailSender.send(message);
        return ResultUtil.success("send templatemail by leealigner@qq.com");
    }

}
