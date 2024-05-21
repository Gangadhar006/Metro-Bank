package com.metro.authservice.repository;

import com.metro.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
