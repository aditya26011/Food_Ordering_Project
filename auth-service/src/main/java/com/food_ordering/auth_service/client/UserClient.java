package com.food_ordering.auth_service.client;

import com.food_ordering.auth_service.auth.AuthUser;
import com.food_ordering.auth_service.dto.AuthUserDto;
import com.food_ordering.auth_service.dto.UserRequestDto;
import com.food_ordering.auth_service.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserClient {

    @PostMapping("/internal/users")
    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto);

    @GetMapping("/internal/users/email/{email}")
    AuthUserDto getUserByEmail(@PathVariable String email);

}
