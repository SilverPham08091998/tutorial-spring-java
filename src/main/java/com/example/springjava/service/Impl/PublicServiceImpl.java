package com.example.springjava.service.Impl;

import com.example.springjava.entity.DistrictEntity;
import com.example.springjava.entity.ProvinceEntity;
import com.example.springjava.entity.WardEntity;
import com.example.springjava.model.DistrictDTO;
import com.example.springjava.model.ProvinceDTO;
import com.example.springjava.model.WardDTO;
import com.example.springjava.respository.DistrictRepository;
import com.example.springjava.respository.ProvinceRepository;
import com.example.springjava.respository.WardRepository;
import com.example.springjava.service.PublicService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class PublicServiceImpl implements PublicService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    WardRepository wardRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String importProvince(MultipartFile excelFile) throws IOException {
        if (provinceRepository.findAll().size() != 0) {
            return "You are imported province";
        }
        List<ProvinceEntity> provinceEntityList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            ProvinceEntity provinceEntity = new ProvinceEntity();
            XSSFRow row = worksheet.getRow(i);
            provinceEntity.setProvinceId(Long.valueOf(row.getCell(2).getStringCellValue()));
            provinceEntity.setProvinceName(row.getCell(1).getStringCellValue());
            provinceEntityList.add(provinceEntity);
        }
        provinceRepository.saveAll(provinceEntityList);
        return "Import Province success";
    }

    @Override
    public String importDistrict(MultipartFile excelFile) throws IOException {
        if (districtRepository.findAll().size() != 0) {
            return "You are imported district";
        }
        List<DistrictEntity> districtEntityList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            DistrictEntity districtEntity = new DistrictEntity();
            XSSFRow row = worksheet.getRow(i);
            districtEntity.setDistrictId(Long.valueOf(row.getCell(1).getStringCellValue()));
            districtEntity.setDistrictName(row.getCell(0).getStringCellValue());
            districtEntity.setProvinceEntity(provinceRepository.findProvinceEntityByProvinceId(Long.valueOf(row.getCell(2).getStringCellValue())));
            districtEntityList.add(districtEntity);
        }
        districtRepository.saveAll(districtEntityList);
        return "Import District success";
    }

    @Override
    public String importWard(MultipartFile excelFile) throws IOException {
        if (wardRepository.findAll().size() != 0) {
            return "You are imported ward";
        }
        List<WardEntity> wardEntityList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            WardEntity wardEntity = new WardEntity();
            XSSFRow row = worksheet.getRow(i);
            wardEntity.setWardId(Long.valueOf(row.getCell(1).getStringCellValue()));
            wardEntity.setWardName(row.getCell(0).getStringCellValue());
            wardEntity.setDistrictEntity(districtRepository.findDistrictEntityByDistrictId(Long.valueOf(row.getCell(2).getStringCellValue())));
            wardEntityList.add(wardEntity);
        }
        wardRepository.saveAll(wardEntityList);
        return "Import Ward success";
    }

    @Override
    public List<ProvinceDTO> getProvince() {
        List<ProvinceEntity> provinceEntityList = provinceRepository.findAll();
        List<ProvinceDTO> provinceDTOList = Arrays.asList(modelMapper.map(provinceEntityList, ProvinceDTO[].class));
        return provinceDTOList;
    }

    @Override
    public List<DistrictDTO> getDistrict(String provinceId) {
        List<DistrictEntity> districtEntityList = districtRepository.findDistrictEntitiesByProvinceEntity_ProvinceId(Long.valueOf(provinceId));
        List<DistrictDTO> districtDTOList = Arrays.asList(modelMapper.map(districtEntityList, DistrictDTO[].class));
        return districtDTOList;
    }

    @Override
    public List<WardDTO> getWard(String provinceId, String districtId) {
        List<WardEntity> wardEntityList = wardRepository.findWardEntitiesByDistrictEntity_DistrictIdAndDistrictEntity_ProvinceEntity_ProvinceId(Long.valueOf(districtId), Long.valueOf(provinceId));
        List<WardDTO> wardDTOList = Arrays.asList(modelMapper.map(wardEntityList, WardDTO[].class));
        return wardDTOList;
    }
}
