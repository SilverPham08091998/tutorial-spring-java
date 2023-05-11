package com.example.springjava.respository;

import com.example.springjava.entity.CategoryOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryOrderRepository extends JpaRepository<CategoryOrderEntity, String> {
    CategoryOrderEntity findCategoryOrderEntityByCategoryOrderId(String categoryOrderId);

    long deleteByCategoryOrderId(String categoryOrderId);
}
