package com.vlabs.arc.core.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlabs.arc.core.domain.deal.DealAction;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MessageReceiver {

    @SneakyThrows
    @JmsListener(destination = "local.inmemory.queue")
    public <T> void receive(String in) {
        log.info("<<< received - {}", in);
        Message<T> message = new ObjectMapper().readValue(in, Message.class);

        Map headers = message.getHeaders();
        String type = (String) headers.get("type");

        Object payload = message.getPayload();

        DealAction dealAction = (DealAction) payload;
        log.info("DealAction - {}", dealAction.toString());
    }
}
