package com.example.springjava.service;

import com.example.springjava.model.DistrictDTO;
import com.example.springjava.model.ProvinceDTO;
import com.example.springjava.model.WardDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PublicService {
    String importProvince(MultipartFile excelFile) throws IOException;

    String importDistrict(MultipartFile excelFile) throws IOException;

    String importWard(MultipartFile excelFile) throws IOException;

    List<ProvinceDTO> getProvince();

    List<DistrictDTO> getDistrict(String provinceId);

    List<WardDTO> getWard(String provinceId, String districtId);


}
