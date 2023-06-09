package com.example.springjava.model;

import lombok.Data;

import java.util.List;

@Data
public class DistrictDTO {

    private Long districtId;

    private String districtName;

    private List<WardDTO> wardDTOList;
}
