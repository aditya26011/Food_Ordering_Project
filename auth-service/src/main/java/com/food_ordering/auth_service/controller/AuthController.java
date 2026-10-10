package com.food_ordering.auth_service.controller;

import com.food_ordering.auth_service.dto.LoginRequestDto;
import com.food_ordering.auth_service.dto.LoginResponseDto;
import com.food_ordering.auth_service.dto.SignUpRequestDto;
import com.food_ordering.auth_service.dto.SignUpResponseDto;
import com.food_ordering.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto= authService.signUp(signUpRequestDto);
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto=authService.login(loginRequestDto);
        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }

}
