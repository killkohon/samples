/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.ponder.springboot.rabbitmq.handler;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author root
 */
@Component
public class Handler {
    @RabbitListener(queues = "myqueue")
    public void processC(Message msg, Channel channel) throws Exception {
        String str = new String(msg.getBody(), "UTF-8");

        if (str.startsWith("N")) {
            System.out.println("Reject:" + str);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        } else {
            System.out.println("Receive:" + str);
        }
    }
}
