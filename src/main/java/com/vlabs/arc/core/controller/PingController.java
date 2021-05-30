package com.vlabs.arc.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        String msg = String.format("pinged [%s] @ [%s]", "arc-core", LocalDateTime.now());
        log.info(msg);
        return msg;
    }
}
