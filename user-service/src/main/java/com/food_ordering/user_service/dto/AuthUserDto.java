package com.food_ordering.user_service.dto;

import com.food_ordering.user_service.entity.Role;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Role role;
}
