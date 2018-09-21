package com.OTT.EmailNotification.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.OTT.EmailNotification.Entity.Mail;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	public ResponseEntity<?> sendMail(Mail mail) throws MessagingException, IOException {

		System.out.println(mail);
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.addAttachment("logo.jpg", new ClassPathResource("download.jpg"));
		Context context = new Context();
		
		context.setVariables(mail.getModel());
		System.out.println(context.getVariables().get("name"));
		String html = templateEngine.process("email-template", context);
		
		
		html=html.replace("${name}", (String) context.getVariables().get("name"));
		html=html.replace("${location}", (String) context.getVariables().get("location"));
		html=html.replace("${signature}", (String) context.getVariables().get("signature"));
		
		System.out.println(html);
		
		helper.setTo(mail.getTo());
		helper.setText(html, true);
		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());

		emailSender.send(message);
		return ResponseEntity.ok("Cool");
	}
}
