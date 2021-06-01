package com.vlabs.arc.core.controller;

import com.vlabs.arc.core.domain.deal.DealAction;
import com.vlabs.arc.core.domain.tranche.TrancheAction;
import com.vlabs.arc.core.engine.Message;
import com.vlabs.arc.core.engine.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    MessageSender messageSender;

    public MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/send/{count}")
    public <T> String send(@PathVariable("count") Integer count) {

        Message message = new Message();

        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                DealAction dealAction = new DealAction("1234", "Draft");
                message.setMessageType("deal");
                message.setPayload(dealAction);
            } else {
                TrancheAction trancheAction = new TrancheAction(101, "Vidhir");
                message.setMessageType("tranche");
                message.setPayload(trancheAction);
            }
            messageSender.send(message);
        }
        return String.format("sent %d messages", count);
    }
}
