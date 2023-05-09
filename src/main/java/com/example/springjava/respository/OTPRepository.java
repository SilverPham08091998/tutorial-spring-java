package com.example.springjava.respository;

import com.example.springjava.entity.OTPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OTPEntity, Long> {
    OTPEntity findOTPEntityByUsernameAndMatching(String username, boolean matching);
}
