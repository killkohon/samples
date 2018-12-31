/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.ponder.springboot.rabbitmq.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author root
 */
@Configuration
public class QueueConfig {
    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", "myqueue_dlx");
        return new Queue("myqueue", true, false, false, args);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue("myqueue_dlx");
    }



    // @Bean
    // public Binding deadLetterBindding() {
    // return BindingBuilder.bind(deadLetterQueue()).to(DirectExchange.DEFAULT).with("myqueue_dlx");
    // }

}
