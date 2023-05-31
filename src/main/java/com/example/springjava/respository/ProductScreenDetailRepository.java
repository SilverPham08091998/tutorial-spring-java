package com.example.springjava.respository;

import com.example.springjava.entity.ProductMonitorDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductScreenDetailRepository extends JpaRepository<ProductMonitorDetailEntity, Long> {
}
