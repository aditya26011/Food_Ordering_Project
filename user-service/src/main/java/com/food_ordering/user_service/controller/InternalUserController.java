package com.food_ordering.user_service.controller;

import com.food_ordering.user_service.dto.UserRequestDto;
import com.food_ordering.user_service.dto.UserResponseDto;
import com.food_ordering.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class InternalUserController {

    private final UserService userService;


    @PostMapping()
    ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
      UserResponseDto user=userService.createUser(userRequestDto);
      return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
