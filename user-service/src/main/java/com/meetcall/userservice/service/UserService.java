package com.meetcall.userservice.service;

import com.meetcall.meetcalldto.exception.UserNotFoundException;
import com.meetcall.meetcalldto.user.*;

import java.util.List;

public interface UserService {

    void deleteUserById(long userSearchDtoId) throws UserNotFoundException;

    void updateUser(UserUpdateDto updateDto) throws UserNotFoundException;

    void saveUser(UserSaveDto userSaveDto);

    UserReadDto getUserById(UserSearchDto searchDto) throws UserNotFoundException;

    List<UserReadDto> getAllUsers();

    void saveAllUsers(List<UserSaveDto> userDtos);

}
