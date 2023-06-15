package com.example.springjava.respository;


import com.example.springjava.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
    DistrictEntity findDistrictEntityByDistrictId(long districtId);

    List<DistrictEntity> findDistrictEntitiesByProvinceEntity_ProvinceId(long provinceId);

}
