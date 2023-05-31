package com.example.springjava.respository;

import com.example.springjava.entity.CategoryProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProductEntity, Long> {
    List<CategoryProductEntity> findCategoryProductEntityByCategoryEntity_CategoryId(Long categoryId);

    CategoryProductEntity findCategoryProductEntityByCategoryProductId(Long categoryProductId);
}
