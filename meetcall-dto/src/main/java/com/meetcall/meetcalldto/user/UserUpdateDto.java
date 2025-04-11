package com.meetcall.meetcalldto.user;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserUpdateDto extends UserDto {

    private final long id;

    public UserUpdateDto(String requestId,
                         String firstName,
                         String lastName,
                         String middleName,
                         LocalDate birthDate,
                         long id) {
        super(requestId, firstName, lastName, middleName, birthDate);
        this.id = id;
    }
}
