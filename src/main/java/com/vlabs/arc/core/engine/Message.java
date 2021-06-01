package com.vlabs.arc.core.engine;

import com.vlabs.arc.core.domain.deal.DealAction;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Message implements Serializable {

    private static final long serialVersionUID = 5337988065299872856L;

    private DealAction dealAction;

    private String type;

}
