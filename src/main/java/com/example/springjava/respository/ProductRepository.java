package com.example.springjava.respository;

import com.example.springjava.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    List<ProductEntity> findProductEntitiesByCategoryProductEntity_CategoryProductId(String categoryProductId);
}
