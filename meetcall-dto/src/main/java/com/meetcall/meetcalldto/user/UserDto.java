package com.meetcall.meetcalldto.user;

import com.meetcall.meetcalldto.AbstractDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class UserDto extends AbstractDto {

    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate birthDate;

    public UserDto(String requestId,
                   String firstName,
                   String lastName,
                   String middleName,
                   LocalDate birthDate) {
        super(requestId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }
}
