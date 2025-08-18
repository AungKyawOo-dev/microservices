package com.aungkyawoo.user_service.repository;

import com.aungkyawoo.user_service.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String phoneNumber);
}
