package com.aungkyawoo.user_service.repository;

import com.aungkyawoo.user_service.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User Repository Interface
 * Author : Aung Kyaw Oo
 */
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Find user by email
     * @param phoneNumber String
     * @return User
     */
    Optional<User> findByEmail(String phoneNumber);
}
