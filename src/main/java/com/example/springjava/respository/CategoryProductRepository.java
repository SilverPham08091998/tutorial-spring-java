package com.example.springjava.respository;

import com.example.springjava.entity.CategoryProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProductEntity, String> {
    List<CategoryProductEntity> findCategoryProductEntitiesByCategoryOrderEntity_CategoryOrderId(String categoryOrderId);

    CategoryProductEntity findCategoryProductEntityByCategoryProductId(String categoryProductId);
}
