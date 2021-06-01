package com.vlabs.arc.core.controller;

import com.vlabs.arc.core.domain.deal.DealAction;
import com.vlabs.arc.core.engine.Message;
import com.vlabs.arc.core.engine.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class MessageController {

    MessageSender messageSender;

    public MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/send/{count}")
    public <T> String send(@PathVariable("count") Integer count) {

        Map<String, Object> headers;
        for (int i = 0; i < count; i++) {

            DealAction dealAction = new DealAction("1234", "Draft");

            Message message = new Message(dealAction, dealAction.getClass().getSimpleName());

            messageSender.send(message);
        }
        return String.format("sent %d messages", count);
    }
}
