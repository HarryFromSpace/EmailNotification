package com.ecms.serviceImpl;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ecms.constants.MessageConstants;
import com.ecms.model.Event;
import com.ecms.service.NotificationService;
import com.ecms.utils.TemplateUtility;
import com.ecms.utils.UserUtility;

/**
 * This is Service Class For Writing Business Logic.
 * 
 * @author nagpalh
 */

@Service
public class NotificationServiceImpl implements NotificationService
{
    @Autowired
    private JavaMailSender javamailSender;
    @Autowired
    private UserUtility userUtility;
    @Autowired
    private TemplateUtility templateUtility;
    private static Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);


    /**
    * Asynchronous function for Sending mail using thymeleaf engines
    * 
    * @param EventDao
    * 
    * @return CompletableFuture<String> It is nothing but Just a String that we
    *         will receive from this function in future, Simply a JAVA-8 Feature.
    * @throws MessagingException 
    */
    @Override
    @Async
    public String sendMail(Event event) throws MessagingException
    {
        log.info(MessageConstants.Enter_Notification_Service);

        MimeMessage message = javamailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        helper = setHelper(helper, event);
        javamailSender.send(message);
        return "Success: " + MessageConstants.Success_Mail_Response;
    }


    public MimeMessageHelper setHelper(MimeMessageHelper helper, Event event) throws MessagingException
    {
        helper.setTo(userUtility.getUser(event).getEmail());
        helper.setText(templateUtility.htmlThymleafTemplate(event), true);
        helper.setSubject(templateUtility.gettemplateSubject(event));
        helper.setFrom("${spring.mail.username}");
        return helper;
    }

}
