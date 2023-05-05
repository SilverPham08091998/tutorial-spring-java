package com.example.springjava.respository;

import com.example.springjava.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select user from USER_PROFILE user where user.address like %:address% and user.fullName like %:fullName% and user.job like %:job%")
    List<UserEntity> findByFullNameOrAddressOrJob(String fullName, String address, String job);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update USER_PROFILE user SET  user.fullName = :fullName, user.age =:age  WHERE user.authenciationEntity.userId = :userId")
    int updateFullNameUserId(@Param(value = "userId") String userId, @Param(value = "fullName") String fullName, @Param(value = "age") int age);

    long deleteByAuthenciationEntity_UserId(String userId);

    UserEntity findUserEntityByAuthenciationEntity_UserId(String userId);

    boolean existsByIdCard(String idCard);
}
