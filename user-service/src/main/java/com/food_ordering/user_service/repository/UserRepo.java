package com.food_ordering.user_service.repository;

import com.food_ordering.user_service.dto.UserRequestDto;
import com.food_ordering.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
