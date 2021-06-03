package com.vlabs.arc.core.events.generics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenericSpringEventListenerAnnotationBased {

    @EventListener
    public void onApplicationEvent(GenericSpringEvent<String> event) {
        log.info("GenericSpringEventListenerAnnotationBased >>> received event - {}", event.getWhat());
    }
}
