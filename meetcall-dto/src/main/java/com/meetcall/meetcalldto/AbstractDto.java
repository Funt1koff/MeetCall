package com.meetcall.meetcalldto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class AbstractDto implements Serializable {

    private final String requestId;

    public AbstractDto(String requestId) {
        this.requestId = requestId;
    }
}
