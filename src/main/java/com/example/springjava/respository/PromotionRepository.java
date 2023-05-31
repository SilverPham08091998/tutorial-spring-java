package com.example.springjava.respository;

import com.example.springjava.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {
}
