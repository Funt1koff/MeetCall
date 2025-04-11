package com.meetcall.meetcalldto.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorResponseField {
    SERVICE("service"),
    MESSAGE("message"),
    CALL_ID("call-id");

    private final String fieldName;
}
