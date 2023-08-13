package com.bloggingapplicationspringboot.services.impl;

import com.bloggingapplicationspringboot.entities.Users;
import com.bloggingapplicationspringboot.exceptions.ResourceNotFoundException;
import com.bloggingapplicationspringboot.payloads.UserDto;
import com.bloggingapplicationspringboot.repositories.UserRepo;
import com.bloggingapplicationspringboot.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = this.dtoToUser(userDto);
        Users savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, UUID userId) {
        Users users = (Users) this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," id ", userId));
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        users.setAbout(userDto.getAbout());

        Users updateUser = this.userRepo.save(users);
        UserDto userDto1 = this.userToDto(updateUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(UUID userId) {

        Users users = (Users) this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ", userId));
        return this.userToDto(users);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users = this.userRepo.findAll();

        List<UserDto> userDtoList = users.stream()
                .map(user -> this.userToDto(user))
                .collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUser(UUID userId) {
        Users users = (Users) this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        this.userRepo.delete(users);

    }

    private Users dtoToUser (UserDto userDto){
        Users users = modelMapper.map(userDto, Users.class);
//        users.setId(userDto.getId());
//        users.setName(userDto.getName());
//        users.setEmail(userDto.getEmail());
//        users.setPassword(userDto.getPassword());
//        users.setAbout(userDto.getAbout());
        return users;
    }

    private UserDto userToDto (Users users){
        UserDto userDto = modelMapper.map(users, UserDto.class);
//        userDto.setId(users.getId());
//        userDto.setName(users.getName());
//        userDto.setEmail(users.getEmail());
//        userDto.setPassword(users.getPassword());
//        userDto.setAbout(users.getAbout());
        return userDto;
    }
}
