package com.example.springjava.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromotionTypeRepository extends JpaRepository<PromotionTypeRepository, Long> {
}
