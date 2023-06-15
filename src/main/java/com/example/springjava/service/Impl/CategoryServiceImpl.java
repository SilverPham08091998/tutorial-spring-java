package com.example.springjava.service.Impl;

import com.example.springjava.entity.CategoryEntity;
import com.example.springjava.model.CategoryDTO;
import com.example.springjava.payload.request.CategoryPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.CategoryRepository;
import com.example.springjava.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryOrderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ApiResponse<String> createCategory(CategoryPayload.CreateCategoryPayload payload) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(payload.getCategoryName());
        categoryEntity.setCategoryStatus(payload.getCategoryStatus());
        categoryOrderRepository.save(categoryEntity);
        return new ApiResponse<>(true, 200, "success", "Category is created");
    }

    @Override
    public ApiResponse<List<CategoryDTO>> getListCategory(String search, String filter) {
        List<CategoryEntity> entityList = categoryOrderRepository.findAll();
        List<CategoryDTO> dtoList = new ArrayList<>();
        for (CategoryEntity entity : entityList) {
            CategoryDTO categoryOrderDTO = modelMapper.map(entity, CategoryDTO.class);
            dtoList.add(categoryOrderDTO);
        }
        return new ApiResponse<>(true, 200, "success", dtoList);
    }

    @Override
    public ApiResponse<String> updateCategory(CategoryPayload.UpdateCategoryPayload payload) {
        CategoryEntity entity = categoryOrderRepository.findCategoryEntitiesByCategoryId(Long.parseLong(payload.getCategoryId()));
        entity.setCategoryName(payload.getCategoryStatus());
        entity.setCategoryStatus(payload.getCategoryName());
        categoryOrderRepository.save(entity);
        return new ApiResponse<>(true, 200, "success", "Category is updated");

    }

    @Override
    @Transactional
    public ApiResponse<String> deleteCategory(CategoryPayload.DeleteCategoryPayload payload) {
        long res = categoryOrderRepository.deleteByCategoryId(Long.valueOf(payload.getCategoryId()));
        if (res == 0) {
            throw new RuntimeException();
        }
        return new ApiResponse<>(true, 200, "success", "Category is deleted");
    }
}
