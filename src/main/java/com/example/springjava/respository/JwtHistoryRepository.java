package com.example.springjava.respository;

import com.example.springjava.entity.JwtHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JwtHistoryRepository extends JpaRepository<JwtHistoryEntity, String> {
    List<JwtHistoryEntity> findJwtHistoryEntitiesByUsername(String username);
}
