package com.food_ordering.user_service.dto;


import com.food_ordering.user_service.entity.Role;
import com.food_ordering.user_service.entity.Status;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private Long phone;
    private Role role;
    private Status status;

}
