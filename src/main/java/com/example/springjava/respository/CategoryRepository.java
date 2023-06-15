package com.example.springjava.respository;

import com.example.springjava.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findCategoryEntitiesByCategoryId(long categoryId);

    long deleteByCategoryId(long categoryId);
}
