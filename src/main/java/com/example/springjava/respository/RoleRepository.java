package com.example.springjava.respository;

import com.example.springjava.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    boolean existsByRoleName(String roleName);
}
