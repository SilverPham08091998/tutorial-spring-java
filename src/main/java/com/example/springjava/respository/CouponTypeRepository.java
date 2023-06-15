package com.example.springjava.respository;

import com.example.springjava.entity.CouponTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponTypeRepository extends JpaRepository<CouponTypeEntity, Long> {
}
