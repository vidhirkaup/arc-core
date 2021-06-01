package com.vlabs.arc.core.engine;

import com.google.gson.Gson;
import com.vlabs.arc.core.domain.deal.DealAction;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceiver {

    @SneakyThrows
    @JmsListener(destination = "local.inmemory.queue")
    public <T> void receive(String in) {
        log.info("<<< received - {}", in);

        Message message = new Gson().fromJson(in, Message.class);
        String type = message.getType();

        if ("DealAction".equals(type)) {
            DealAction dealAction = message.getDealAction();
            log.info("payload : {}", dealAction);
        }
    }
}
