package com.ecms.notification.strategy;

import com.ecms.model.Event;

public interface NotificationStrategy
{
    public String sendMessage(Event event);
}
