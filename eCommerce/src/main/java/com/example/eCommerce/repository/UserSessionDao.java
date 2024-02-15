package com.example.eCommerce.repository;

import com.example.eCommerce.models.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSessionDao extends JpaRepository<UserSession,Long> {
    Optional<UserSession> findByToken(String token);
    Optional<UserSession> findByUserId(Long userId);
}
