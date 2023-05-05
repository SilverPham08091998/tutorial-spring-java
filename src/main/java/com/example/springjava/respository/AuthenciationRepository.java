package com.example.springjava.respository;

import com.example.springjava.entity.AuthenciationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenciationRepository extends JpaRepository<AuthenciationEntity, String> {
    AuthenciationEntity findAuthenciationEntityByUsername(String username);

    boolean existsByUsername(String username);
}
