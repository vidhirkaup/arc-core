package com.vlabs.arc.core.engine;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Map;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 5337988065299872856L;

    private T payload;

    private Map<String, Object> headers;

}
