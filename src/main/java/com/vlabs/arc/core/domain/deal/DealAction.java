package com.vlabs.arc.core.domain.deal;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DealAction implements Serializable {
    private static final long serialVersionUID = 8790360459164896107L;
    private String id;
    private String status;
}
