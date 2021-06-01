package com.vlabs.arc.core.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Slf4j
@Component
public class MessageSender {

    private JmsTemplate jmsTemplate;

    private Queue queue;

    public MessageSender(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @SneakyThrows
    public void send(Message message) {
        String msg = new Gson().toJson(message);

        log.info(">>> sending - {}", msg);
        jmsTemplate.convertAndSend(queue, msg);
    }
}
