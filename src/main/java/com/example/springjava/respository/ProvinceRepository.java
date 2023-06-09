package com.example.springjava.respository;


import com.example.springjava.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
    ProvinceEntity findProvinceEntityByProvinceId(Long provinceId);
}
