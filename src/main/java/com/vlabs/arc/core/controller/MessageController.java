package com.vlabs.arc.core.controller;

import com.vlabs.arc.core.service.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    MessageSender messageSender;

    public MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/send/{count}")
    public String send(@PathVariable("count") Integer count) {
        for (int i = 0; i < count; i++) {
            messageSender.send("test - " + i);
        }
        return String.format("sent %d messages", count);
    }
}
