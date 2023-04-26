package com.example.springjava.respository;

import com.example.springjava.entity.UserEntity;
import com.example.springjava.model.userdto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select user from USER user where user.address like %:address% and user.fullName like %:fullName% and user.job like %:job%", nativeQuery = false)
    List<UserEntity> findByFullNameOrAddressOrJob(String fullName, String address, String job);

    @Modifying
    @Query("update USER user SET  user = :userDTO WHERE user.userId = :userId")
    void updateUserEntityByUserId(@Param("user") UserDTO userDTO, @Param("userId") String userId);
}
