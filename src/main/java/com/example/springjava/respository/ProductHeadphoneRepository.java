package com.example.springjava.respository;

import com.example.springjava.entity.ProductHeadphoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHeadphoneRepository extends JpaRepository<ProductHeadphoneEntity, Long> {
}
