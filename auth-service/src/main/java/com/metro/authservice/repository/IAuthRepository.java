package com.metro.authservice.repository;

import com.metro.shared.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
}
