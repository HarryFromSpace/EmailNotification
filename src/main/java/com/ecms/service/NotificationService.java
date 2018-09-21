package com.ecms.service;

import javax.mail.MessagingException;

import com.ecms.model.Event;

public interface NotificationService
{
    String sendMail(Event event) throws MessagingException;
}
