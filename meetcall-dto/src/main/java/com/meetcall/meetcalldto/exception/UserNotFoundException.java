package com.meetcall.meetcalldto.exception;

public class UserNotFoundException extends ResourceNotFoundException{

    public UserNotFoundException(String service, String message, String callId) {
        super(service, message, callId);
    }
}
