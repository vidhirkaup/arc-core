package com.vlabs.arc.core.domain.tranche;

import com.vlabs.arc.core.engine.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrancheAction extends Message {
    private static final long serialVersionUID = -772809207905163422L;
    private long id;
    private String name;
}
