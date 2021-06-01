package com.vlabs.arc.core.domain.deal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DealAction implements Serializable {
    private static final long serialVersionUID = -3520768734188188375L;
    private String id;
    private String status;
}
