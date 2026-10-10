package com.food_ordering.auth_service.service;

import com.food_ordering.auth_service.auth.AuthUser;
import com.food_ordering.auth_service.client.UserClient;
import com.food_ordering.auth_service.dto.*;
import com.food_ordering.auth_service.dto.enums.Role;
import com.food_ordering.auth_service.dto.enums.Status;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserClient userClient;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

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

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
     Authentication authentication=authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword()));

         AuthUser user = (AuthUser) authentication.getPrincipal();

         String token=jwtService.generateToken(user);

         return new LoginResponseDto(user.getId(),user.getUsername(),token);

    }
}
