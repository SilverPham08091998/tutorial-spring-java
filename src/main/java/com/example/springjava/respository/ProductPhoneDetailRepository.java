package com.example.springjava.respository;

import com.example.springjava.entity.ProductPhoneDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductPhoneDetailRepository extends JpaRepository<ProductPhoneDetailEntity, Long> {
}
