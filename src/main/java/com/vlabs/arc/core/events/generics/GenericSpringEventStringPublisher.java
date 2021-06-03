package com.vlabs.arc.core.events.generics;

import com.vlabs.arc.core.events.CustomSpringEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenericSpringEventStringPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishGenericEvent(final String message) {
        log.info(" >>> publish generic event");
        GenericSpringStringEvent genericSpringStringEvent = new GenericSpringStringEvent(message);
        applicationEventPublisher.publishEvent(genericSpringStringEvent);
    }
}
