package com.meetcall.userservice.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceConstraints {
    SERVICE_NAME("user-service");

    private final String fieldValue;
}
