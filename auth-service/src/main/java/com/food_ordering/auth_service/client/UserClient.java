package com.food_ordering.auth_service.client;

import com.food_ordering.auth_service.dto.UserRequestDto;
import com.food_ordering.auth_service.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserClient {

    @PostMapping("/internal/users")
    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto);
}
