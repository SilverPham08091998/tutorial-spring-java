package com.example.springjava.respository;

import com.example.springjava.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findProductEntitiesByCategoryProductEntity_CategoryProductId(Long categoryProductId);
}
