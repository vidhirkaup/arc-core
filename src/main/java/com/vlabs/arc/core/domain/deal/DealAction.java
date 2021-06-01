package com.vlabs.arc.core.domain.deal;

import com.vlabs.arc.core.engine.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DealAction extends Message {
    private static final long serialVersionUID = -3520768734188188375L;
    private String id;
    private String status;
}
