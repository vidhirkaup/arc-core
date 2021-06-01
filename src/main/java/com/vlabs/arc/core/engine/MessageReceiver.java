package com.vlabs.arc.core.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlabs.arc.core.domain.deal.DealAction;
import com.vlabs.arc.core.domain.tranche.TrancheAction;
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

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, ?> map = objectMapper.readValue(in, Map.class);

        String messageType = (String) map.get("messageType");

        log.info("messageType --> {}", messageType);

        if (messageType.equalsIgnoreCase("deal")) {
            DealAction dealAction = objectMapper.readValue(in, DealAction.class);
            log.info("payload : {}", dealAction);
        } else if (messageType.equalsIgnoreCase("tranche")) {
            TrancheAction trancheAction = objectMapper.readValue(in, TrancheAction.class);
            log.info("payload : {}", trancheAction);
        }
    }
}
