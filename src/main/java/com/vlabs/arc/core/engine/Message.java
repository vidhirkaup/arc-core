package com.vlabs.arc.core.engine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 5337988065299872856L;
    private String messageType;
    private T payload;
}
