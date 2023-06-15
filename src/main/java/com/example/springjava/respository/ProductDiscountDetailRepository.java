package com.example.springjava.respository;

import com.example.springjava.entity.ProductDiscountDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountDetailRepository extends JpaRepository<ProductDiscountDetailEntity, Long> {
}
