package com.example.springjava.respository;

import com.example.springjava.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>, JpaSpecificationExecutor<OrderDetailEntity> {
    List<OrderDetailEntity> findOrderDetailEntitiesByUserEntity_ProfileId(Long profileId);


}
