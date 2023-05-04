package com.example.springjava.respository;

import com.example.springjava.entity.AuthenciationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenciationRepository extends JpaRepository<AuthenciationEntity, String> {
    AuthenciationEntity findAuthenciationEntityByUsername(String username);

    boolean existsByUsername(String username);
}
