package com.food_ordering.auth_service.dto;


import com.food_ordering.auth_service.dto.enums.Role;
import com.food_ordering.auth_service.dto.enums.Status;
import lombok.Data;

@Data
public class SignUpRequestDto {
    private String username;
    private String email;
    private String password;
    private Status status;
    private Long phone;
    private Role role;



}
