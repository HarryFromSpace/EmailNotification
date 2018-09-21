package com.ecms.producer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ecms.constants.MessageConstants;
import com.ecms.model.Event;

/**
 * This class will act as producer and will send notification on RabbitMQ Queue
 * 
 * @author nagpalh
 *
 */
@Component
public class Producer
{

    private static Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mail.rabbitmq.exchange}")
    private String exchange;

    @Value("${mail.rabbitmq.routingkey}")
    private String routingkey;


    /**
     * Just for sending mail object to specific "exchange" with specified "routing
     * key". Now, that routing key is used by exchanges for routing message to the
     * specific "Queue".
     * 
     * @param EventDao
     * @throws IOException
     * @throws TimeoutException
     */
    public String produce(Event event) throws IOException, TimeoutException
    {
        log.info(MessageConstants.Enter_Producer);
        amqpTemplate.convertAndSend(exchange, routingkey, event);
        return MessageConstants.Producer_Result;
    }
}
