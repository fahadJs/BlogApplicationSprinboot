package com.bloggingapplicationspringboot.controllers;

import com.bloggingapplicationspringboot.payloads.ApiResponse;
import com.bloggingapplicationspringboot.payloads.UserDto;
import com.bloggingapplicationspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

//    Adding Test Comment from second device after Cloning!

    @Autowired
    private UserService userService;

//    POST REQUEST
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser((userDto));
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

//    PUT REQUEST
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    DELETE REQUEST
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Succesfully!",true), HttpStatus.OK);
    }

//    GET SINGLE USER
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return new ResponseEntity<>(this.userService.getUserById(userId), HttpStatus.OK);
    }

//    GET ALL USERS
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }
}
