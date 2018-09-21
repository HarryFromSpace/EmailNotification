package com.ecms.notification.strategyImpl;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecms.model.Event;
import com.ecms.notification.strategy.NotificationStrategy;
import com.ecms.service.NotificationService;

@Component
public class MailStrategy implements NotificationStrategy
{
    @Autowired
    private NotificationService notificationService;

    private static Logger log = LoggerFactory.getLogger(MailStrategy.class);


    @Override
    public String sendMessage(Event event)
    {
        try
        {
            notificationService.sendMail(event);
        }
        catch (MessagingException e)
        {
            log.info(e.getMessage());
        }
        return "success";
    }

}
