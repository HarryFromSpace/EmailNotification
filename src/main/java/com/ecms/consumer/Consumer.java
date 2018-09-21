package com.ecms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecms.constants.MessageConstants;
import com.ecms.model.Event;
import com.ecms.notification.factory.NotificationFactory;
import com.ecms.notification.strategy.NotificationStrategy;

/**
 * This Class Acts as Consumer (Or Listener). and will Listen to The messages on
 * queue.
 * 
 * @author nagpalh
 */
@Component
@EnableRabbit
public class Consumer
{
    private static Logger log = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    private NotificationFactory notificationFactory;
    /**
     * This Function Listens to the messages on given queues.
     * 
     * @param EventDao
     */
    @RabbitListener(queues = "${mail.rabbitmq.queue}", containerFactory = "mailFactory")
    public void recievedMessage(Event event)
    {
        String typeOfMessage = "mail";
        log.info(MessageConstants.Enter_Consumer + event);
        NotificationStrategy notificationStrategy = notificationFactory.getNotificationStrategy(typeOfMessage);
        String output = notificationStrategy.sendMessage(event);
        log.info(MessageConstants.Call_After_Asynch + output);
    }

}
