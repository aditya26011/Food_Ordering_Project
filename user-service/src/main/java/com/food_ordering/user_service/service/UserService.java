package com.food_ordering.user_service.service;

import com.food_ordering.user_service.dto.AuthUserDto;
import com.food_ordering.user_service.dto.UserRequestDto;
import com.food_ordering.user_service.dto.UserResponseDto;
import com.food_ordering.user_service.entity.Role;
import com.food_ordering.user_service.entity.Status;
import com.food_ordering.user_service.entity.User;
import com.food_ordering.user_service.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;


    public UserResponseDto createUser(UserRequestDto userRequestDto) {
    Optional<User> user= userRepo.findByEmail(userRequestDto.getEmail());
    if(user.isPresent()){
        throw new RuntimeException("User is already Present");
    }
    User newUser=new User();
    newUser.setEmail(userRequestDto.getEmail());
    newUser.setRole(userRequestDto.getRole());
    newUser.setPhone(userRequestDto.getPhone());
    newUser.setStatus(userRequestDto.getStatus());
    newUser.setPassword(userRequestDto.getPassword());
    newUser.setUsername(userRequestDto.getUsername());

   User savedUser= userRepo.save(newUser);


    UserResponseDto userResponseDto=new UserResponseDto();

    userResponseDto.setEmail(savedUser.getEmail());
    userResponseDto.setStatus(savedUser.getStatus());
    userResponseDto.setUsername(savedUser.getUsername());
    userResponseDto.setRole(savedUser.getRole());
    userResponseDto.setId(savedUser.getId());
    userResponseDto.setPhone(savedUser.getPhone());

    return  userResponseDto;

    }

    public AuthUserDto getUserByEmail(String email) {
     User user=userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not present"));

      AuthUserDto authUserDto=new AuthUserDto();
      authUserDto.setEmail(user.getEmail());
      authUserDto.setId(user.getId());
      authUserDto.setPassword(user.getPassword());
      authUserDto.setUsername(user.getUsername());
      authUserDto.setRole(user.getRole());

      return authUserDto;


    }
}
