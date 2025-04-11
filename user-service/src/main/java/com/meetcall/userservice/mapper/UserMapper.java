package com.meetcall.userservice.mapper;

import com.meetcall.meetcalldto.user.UserDto;
import com.meetcall.meetcalldto.user.UserReadDto;
import com.meetcall.meetcalldto.user.UserSaveDto;
import com.meetcall.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserReadDto entityToReadDto(User entity);

    List<UserReadDto> entityToReadDto(List<User> users);

    List<User> saveDtoToEntity(List<UserSaveDto> dtos);

    User saveDtoToEntity(UserSaveDto dto);

}
