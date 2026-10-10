package com.food_ordering.auth_service.service;

import com.food_ordering.auth_service.auth.AuthUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    SecretKey genrateSecretKey(){
       return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }


    String generateToken(AuthUser user){
      return  Jwts.builder()
                .subject(user.getId().toString())
                .claim("role",user.getRole())
                .claim("email",user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000 * 60 *10))
                .signWith(genrateSecretKey())
                .compact();
    }

}
