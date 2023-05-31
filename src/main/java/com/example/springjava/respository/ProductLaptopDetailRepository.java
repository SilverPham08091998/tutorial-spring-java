package com.example.springjava.respository;

import com.example.springjava.entity.ProductLaptopDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLaptopDetailRepository extends JpaRepository<ProductLaptopDetailEntity, Long> {
}
