package com.food_ordering.auth_service.service;

import com.food_ordering.auth_service.auth.AuthUser;
import com.food_ordering.auth_service.client.UserClient;
import com.food_ordering.auth_service.dto.AuthUserDto;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetail implements UserDetailsService {

    private final UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserDto userByEmail = userClient.getUserByEmail(username);

        AuthUser authUser=new AuthUser();
        authUser.setUsername(userByEmail.getUsername());
        authUser.setId(userByEmail.getId());
        authUser.setRole(userByEmail.getRole());
        authUser.setPassword(userByEmail.getPassword());
        authUser.setEmail(userByEmail.getEmail());

        return authUser;


    }
}
