package com.vlabs.arc.core.engine;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlabs.arc.core.domain.deal.DealAction;
import com.vlabs.arc.core.domain.tranche.TrancheAction;
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

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode map = objectMapper.readTree(in);

        String messageType = map.get("messageType")
                                .asText();

        JsonNode payload = map.get("payload");

        log.info("messageType --> {}", messageType);
        log.info("payload --> {}", payload);

        if (messageType.equalsIgnoreCase("deal")) {
            DealAction dealAction = objectMapper.convertValue(payload, new TypeReference<DealAction>() { });
            log.info("dealAction payload : {}", dealAction);
        } else if (messageType.equalsIgnoreCase("tranche")) {
            TrancheAction trancheAction = objectMapper.convertValue(payload, new TypeReference<TrancheAction>() { });
            log.info("trancheAction payload : {}", trancheAction);
        }
    }
}
