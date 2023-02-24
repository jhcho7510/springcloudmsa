package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
//import org.springframework.security.core.userdetails.UserDetails;

public interface UserService { // extends UserDetails
    UserDto createUser(UserDto userDto);
}
