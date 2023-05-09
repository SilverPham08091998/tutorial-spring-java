package com.example.springjava.respository;

import com.example.springjava.entity.CategoryOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryOrderRepository extends JpaRepository<CategoryOrderEntity, String> {
}
