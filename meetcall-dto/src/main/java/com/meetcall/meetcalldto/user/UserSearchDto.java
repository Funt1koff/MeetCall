package com.meetcall.meetcalldto.user;

import com.meetcall.meetcalldto.AbstractDto;
import lombok.Getter;

@Getter
public class UserSearchDto extends AbstractDto {

    private long userId;

    public UserSearchDto(String requestId) {
        super(requestId);
    }
}
