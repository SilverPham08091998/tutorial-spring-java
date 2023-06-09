package com.example.springjava.respository;

import com.example.springjava.entity.WardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WardRepository extends JpaRepository<WardEntity, Long> {
    List<WardEntity> findWardEntitiesByDistrictEntity_DistrictIdAndDistrictEntity_ProvinceEntity_ProvinceId(Long districtId, Long provinceId);
}
