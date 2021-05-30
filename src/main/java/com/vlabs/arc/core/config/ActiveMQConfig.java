package com.vlabs.arc.core.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms
public class ActiveMQConfig {

    @Bean
    public Queue createQueue() {
        return new ActiveMQQueue("local.inmemory.queue");
    }

}
