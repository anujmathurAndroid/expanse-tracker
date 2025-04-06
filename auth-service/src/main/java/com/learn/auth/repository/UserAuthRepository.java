package com.learn.auth.repository;

import com.learn.auth.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, String> {
    Optional<UserAuth> findByUsername(String username);
}

