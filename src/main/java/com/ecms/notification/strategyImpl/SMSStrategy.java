package com.ecms.notification.strategyImpl;

import org.springframework.stereotype.Component;

import com.ecms.model.Event;
import com.ecms.notification.strategy.NotificationStrategy;

@Component
public class SMSStrategy implements NotificationStrategy
{

    @Override
    public String sendMessage(Event event)
    {
        return null;
    }

}
