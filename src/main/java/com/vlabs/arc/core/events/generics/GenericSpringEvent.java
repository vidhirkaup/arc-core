package com.vlabs.arc.core.events.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericSpringEvent<T> {

    private T what;

}
