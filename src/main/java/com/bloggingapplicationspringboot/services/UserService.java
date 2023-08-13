package com.bloggingapplicationspringboot.services;

import com.bloggingapplicationspringboot.payloads.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, UUID userId);
    UserDto getUserById(UUID userId);
    List<UserDto> getAllUsers();
    void deleteUser(UUID userId);
}
