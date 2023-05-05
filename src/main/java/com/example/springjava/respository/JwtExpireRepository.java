package com.example.springjava.respository;

import com.example.springjava.entity.JWTExpireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtExpireRepository extends JpaRepository<JWTExpireEntity, String> {

}
