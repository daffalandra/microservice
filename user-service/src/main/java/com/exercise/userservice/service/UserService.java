package com.exercise.userservice.service;

import com.exercise.userservice.dto.CreateUserRequestDto;
import com.exercise.userservice.dto.CreateUserResponseDto;
import com.exercise.userservice.dto.GetUsersRequestDto;
import com.exercise.userservice.dto.GetUsersResponseDto;

public interface UserService {

    GetUsersResponseDto getUsers(GetUsersRequestDto requestDto);

    CreateUserResponseDto createUser(CreateUserRequestDto requestDto);
}
