package com.meetcall.userservice.service.impl;

import com.meetcall.meetcalldto.exception.UserNotFoundException;
import com.meetcall.meetcalldto.user.*;
import com.meetcall.userservice.entity.User;
import com.meetcall.userservice.mapper.UserMapper;
import com.meetcall.userservice.repository.UserRepository;
import com.meetcall.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.meetcall.userservice.constraints.ServiceConstraints.SERVICE_NAME;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }

    @Override
    @Transactional
    public void updateUser(UserUpdateDto userDto) throws UserNotFoundException {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new UserNotFoundException(
                SERVICE_NAME.getFieldValue(), "User with id = " + userDto.getId() + "not found", userDto.getRequestId()
        ));
        patchUpdate(user, userDto);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void saveUser(UserSaveDto userSaveDto) {
        User user = userMapper.saveDtoToEntity(userSaveDto);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserReadDto getUserById(UserSearchDto searchDto) throws UserNotFoundException {
        User user = userRepository.findById(searchDto.getUserId()).orElseThrow(() -> new UserNotFoundException(
                SERVICE_NAME.getFieldValue(),
                "User with id = " + searchDto.getUserId() + " not found" ,
                searchDto.getRequestId()
        ));
        return userMapper.entityToReadDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserReadDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.entityToReadDto(users);
    }

    @Override
    @Transactional
    public void saveAllUsers(List<UserSaveDto> userDtos) {
        List<User> transientUsers = userMapper.saveDtoToEntity(userDtos);
        userRepository.saveAll(transientUsers);
    }

    private void patchUpdate(User user, UserDto userDto) {

        if (userDto.getFirstName() != null) {
            user.setFirstName(userDto.getFirstName());
        }

        if (userDto.getLastName() != null) {
            user.setLastName(userDto.getLastName());
        }

        if (userDto.getMiddleName() != null) {
            user.setMiddleName(userDto.getMiddleName());
        }

        if (userDto.getBirthDate() != null) {
            user.setBirthDate(userDto.getBirthDate());
        }
    }
}
