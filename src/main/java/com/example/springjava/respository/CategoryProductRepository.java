package com.example.springjava.respository;

import com.example.springjava.entity.CategoryProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProductEntity, String> {
}
