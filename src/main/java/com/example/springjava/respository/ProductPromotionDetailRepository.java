package com.example.springjava.respository;

import com.example.springjava.entity.ProductPromotionDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPromotionDetailRepository extends JpaRepository<ProductPromotionDetailEntity, Long> {
}
