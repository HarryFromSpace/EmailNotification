package com.ecms.notification.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecms.notification.strategy.NotificationStrategy;
import com.ecms.notification.strategyImpl.LiveNotificationStrategy;
import com.ecms.notification.strategyImpl.MailStrategy;
import com.ecms.notification.strategyImpl.SMSStrategy;

@Component
public class NotificationFactory
{
    @Autowired
    private MailStrategy mailStrategy;


    public NotificationStrategy getNotificationStrategy(String type)
    {
        if ("mail".equalsIgnoreCase(type))
            return mailStrategy;
        else if ("sms".equalsIgnoreCase(type))
            return new SMSStrategy();
        else if ("live-notification".equalsIgnoreCase(type))
            return new LiveNotificationStrategy();
        return null;
    }
}
