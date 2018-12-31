/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.ponder.springboot.rabbitmq.handler;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author root
 */
@Component
@RabbitListener(queues = "myqueue")
public class Handler {
    @RabbitHandler
    public void processC(String str, Message message, Channel channel) throws Exception {

        
        if (str.startsWith("N")) {
            System.out.println("Reject:" + str);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        } else {
            System.out.println("Receive:" + str);
        }
    }
}
