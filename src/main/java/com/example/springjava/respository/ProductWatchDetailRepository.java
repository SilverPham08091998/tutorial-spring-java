package com.example.springjava.respository;

import com.example.springjava.entity.ProductWatchDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductWatchDetailRepository extends JpaRepository<ProductWatchDetailEntity, Long> {
}
