package com.OTT.EmailNotification;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.OTT.EmailNotification.Entity.Mail;
import com.OTT.EmailNotification.Service.EmailService;

@SpringBootApplication
public class EmailNotificationApplication implements ApplicationRunner {
	private static Logger log = LoggerFactory.getLogger(EmailNotificationApplication.class);
	
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailNotificationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		 log.info("Sending Email with Thymeleaf HTML Template Example");

	        Mail mail = new Mail();
	        mail.setFrom("himanshunagpal7777@gmail.com");
	        mail.setTo("himanshunagpal2615@gmail.com");
	        mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

	        Map<String, String> model = new HashMap<String, String>();
	        model.put("name", "Himanshu");
	        model.put("location", "India");
	        model.put("signature", "Himanshu Nagpal");
	        mail.setModel(model);

	        emailService.sendMail(mail);

	}
}
