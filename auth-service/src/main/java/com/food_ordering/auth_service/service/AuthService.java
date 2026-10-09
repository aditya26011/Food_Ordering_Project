package com.food_ordering.auth_service.service;

import com.food_ordering.auth_service.client.UserClient;
import com.food_ordering.auth_service.dto.SignUpRequestDto;
import com.food_ordering.auth_service.dto.SignUpResponseDto;
import com.food_ordering.auth_service.dto.UserRequestDto;
import com.food_ordering.auth_service.dto.UserResponseDto;
import com.food_ordering.auth_service.dto.enums.Role;
import com.food_ordering.auth_service.dto.enums.Status;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserClient userClient;
    private final ModelMapper modelMapper;

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        UserRequestDto userRequestDto=new UserRequestDto();
        userRequestDto.setEmail(signUpRequestDto.getEmail());
        userRequestDto.setUsername(signUpRequestDto.getUsername());
        userRequestDto.setRole(Role.USER);
        userRequestDto.setStatus(Status.ACTIVE);
        userRequestDto.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        userRequestDto.setPhone(signUpRequestDto.getPhone());

       UserResponseDto userResponseDto= userClient.createUser(userRequestDto);

      return  modelMapper.map(userResponseDto, SignUpResponseDto.class);




    }
}
