package com.ponder.springboot.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class EntranceController {

    @Autowired
    private RabbitTemplate template;

    @RequestMapping("/send/{times}/{message}")
    public String send(@PathVariable("times") int times, @PathVariable("message") String msg) {
        for (int i = 0; i < times; i++) {
            template.convertAndSend("myqueue", msg + "_" + System.currentTimeMillis());
        }
        return "finished";
    }

}
