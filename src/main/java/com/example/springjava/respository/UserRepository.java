package com.example.springjava.respository;

import com.example.springjava.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByFullNameOrAddressOrJob(String fullName, String address, String job);
}
