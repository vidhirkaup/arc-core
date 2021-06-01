package com.vlabs.arc.core.domain.tranche;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrancheAction implements Serializable {
    private static final long serialVersionUID = -772809207905163422L;
    private long id;
    private String name;
}
