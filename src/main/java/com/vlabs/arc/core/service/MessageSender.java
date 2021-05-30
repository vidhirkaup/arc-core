package com.vlabs.arc.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Slf4j
@Service
public class MessageSender {

    private JmsTemplate jmsTemplate;

    private Queue queue;

    public MessageSender(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public void send(String message) {
        log.info(">>> sending - {}", message);
        jmsTemplate.convertAndSend(queue, message);
    }
}
