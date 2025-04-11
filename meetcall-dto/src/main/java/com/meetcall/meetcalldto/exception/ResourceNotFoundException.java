package com.meetcall.meetcalldto.exception;

import com.meetcall.meetcalldto.model.response.ErrorResponse;

import static com.meetcall.meetcalldto.model.response.ErrorResponseField.*;

public class ResourceNotFoundException extends Exception {

    private final String service;
    private final String message;
    private final String callId;

    public ResourceNotFoundException(String service, String message, String callId) {
        super(message);
        this.service = service;
        this.message = message;
        this.callId = callId;
    }

    public ErrorResponse getResponsePayload() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.put(CALL_ID.getFieldName(), callId);
        errorResponse.put(SERVICE.getFieldName(), service);
        errorResponse.put(MESSAGE.getFieldName(), message);
        return errorResponse;
    }
}
