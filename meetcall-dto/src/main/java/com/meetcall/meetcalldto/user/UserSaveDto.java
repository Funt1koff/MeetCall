package com.meetcall.meetcalldto.user;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserSaveDto extends UserDto {

    public UserSaveDto(String requestId,
                       String firstName,
                       String lastName,
                       String middleName,
                       LocalDate birthDate) {
        super(requestId, firstName, lastName, middleName, birthDate);
    }
}
