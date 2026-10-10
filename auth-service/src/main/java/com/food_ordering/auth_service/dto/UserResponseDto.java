package com.food_ordering.auth_service.dto;


import com.food_ordering.auth_service.dto.enums.Role;
import com.food_ordering.auth_service.dto.enums.Status;
import lombok.Data;

@Data
public class UserResponseDto {
    private String username;
    private String email;
    private Long id;
    private Status status;
    private Role role;
    private String phone;
}
