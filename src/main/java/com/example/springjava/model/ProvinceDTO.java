package com.example.springjava.model;

import lombok.Data;

import java.util.List;

@Data
public class ProvinceDTO {

    private int provinceId;

    private String provinceName;

    private List<DistrictDTO> districtDTOList;

}
