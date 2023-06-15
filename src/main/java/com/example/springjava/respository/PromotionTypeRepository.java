package com.example.springjava.respository;

import com.example.springjava.entity.PromotionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromotionTypeRepository extends JpaRepository<PromotionTypeEntity, Long> {
}
