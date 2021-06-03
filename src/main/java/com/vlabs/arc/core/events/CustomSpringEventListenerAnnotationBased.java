package com.vlabs.arc.core.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomSpringEventListenerAnnotationBased {

    @EventListener
    public void  onApplicationEvent(CustomSpringEvent event) {
        log.info(" CustomSpringEventListenerAnnotationBased >>> received spring custom event {}", event.getMessage());
    }
}
