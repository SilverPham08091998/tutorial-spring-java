package com.example.springjava.respository;

import com.example.springjava.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select user from USER user where user.address like %:address% and user.fullName like %:fullName% and user.job like %:job%", nativeQuery = false)
    List<UserEntity> findByFullNameOrAddressOrJob(String fullName, String address, String job);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update USER user SET  user.fullName = :fullName, user.age =:age  WHERE user.userId = :userId")
    int updateFullNameUserId(@Param(value = "userId") String userId, @Param(value = "fullName") String fullName, @Param(value = "age") int age);

    long deleteByUserId(String userId);

    UserEntity findUserEntityByUserId(String userId);
}
