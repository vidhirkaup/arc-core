package com.vlabs.arc.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceiver {

    @JmsListener(destination = "local.inmemory.queue")
    public void receive(String message) {
        log.info("<<< received - {}", message);
    }
}
