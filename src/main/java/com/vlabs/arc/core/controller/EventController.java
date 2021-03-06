package com.vlabs.arc.core.controller;

import com.vlabs.arc.core.events.CustomSpringEventPublisher;
import com.vlabs.arc.core.events.generics.GenericSpringEventStringPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EventController {

    @Autowired
    private CustomSpringEventPublisher publisher;

    @Autowired
    private GenericSpringEventStringPublisher genericPublisher;

    @GetMapping("/raise/event/{count}")
    public <T> String raise(@PathVariable("count") Integer count) {

        for (int i = 0; i < count; i++) {
            log.info("-------------------------------------------");
            publisher.publishCustomEvent("this is a custom event." + i);
        }
        return String.format("raised %d events", count);
    }

    @GetMapping("/raise/event/special/{count}")
    public <T> String raiseSpecial(@PathVariable("count") Integer count) {

        for (int i = 0; i < count; i++) {
            log.info("-------------------------------------------");
            genericPublisher.publishGenericEvent("this is a generic event." + i);
        }
        return String.format("raised %d events", count);
    }

}
