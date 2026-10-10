package com.food_ordering.auth_service.dto;



import com.food_ordering.auth_service.dto.enums.Role;
import com.food_ordering.auth_service.dto.enums.Status;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role role;
    private Status status;

}
