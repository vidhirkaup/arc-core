package com.vlabs.arc.core.engine;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.vlabs.arc.core.domain.deal.DealAction;
import com.vlabs.arc.core.domain.tranche.TrancheAction;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = As.PROPERTY, property = "messageType")
@JsonSubTypes({

        @JsonSubTypes.Type(value = DealAction.class, name = "deal"),
        @JsonSubTypes.Type(value = TrancheAction.class, name = "tranche")
})
public abstract class Message implements Serializable {

    private static final long serialVersionUID = 5337988065299872856L;
}
