package com.food_ordering.user_service.dto;

import com.food_ordering.user_service.entity.Role;
import com.food_ordering.user_service.entity.Status;
import lombok.Data;

@Data
public class UserResponseDto {
    private String username;
    private String email;
    private Long id;
    private Status status;
    private Role role;
}
