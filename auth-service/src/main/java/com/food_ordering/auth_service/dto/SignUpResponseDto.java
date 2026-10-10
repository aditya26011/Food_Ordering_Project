package com.food_ordering.auth_service.dto;

import com.food_ordering.auth_service.dto.enums.Role;
import com.food_ordering.auth_service.dto.enums.Status;
import lombok.Data;

@Data
public class SignUpResponseDto {
    private String username;
    private String email;
    private Long id;
    private Status status;
    private String phone;
    private Role role;
}
