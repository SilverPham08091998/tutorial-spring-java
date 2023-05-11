package com.example.springjava.service.Impl;

import com.example.springjava.entity.CategoryOrderEntity;
import com.example.springjava.model.CategoryOrderDTO;
import com.example.springjava.payload.request.CategoryOrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.CategoryOrderRepository;
import com.example.springjava.service.CategoryOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryOrderServiceImpl implements CategoryOrderService {
    @Autowired
    CategoryOrderRepository categoryOrderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ApiResponse<String> createOrderCategory(CategoryOrderPayload.CreateCategoryOrderPayload payload) {
        CategoryOrderEntity categoryOrderEntity = new CategoryOrderEntity();
        categoryOrderEntity.setCategoryOrderName(payload.getCategoryName());
        categoryOrderEntity.setCategoryOrderStatus(payload.getCategoryStatus());
        categoryOrderRepository.save(categoryOrderEntity);
        return new ApiResponse<>(true, 200, "success", "Category is created");
    }

    @Override
    public ApiResponse<List<CategoryOrderDTO>> getListCategoryOrder(String search, String filter) {
        List<CategoryOrderEntity> entityList = categoryOrderRepository.findAll();
        List<CategoryOrderDTO> dtoList = new ArrayList<>();
        for (CategoryOrderEntity entity : entityList) {
            CategoryOrderDTO categoryOrderDTO = modelMapper.map(entity, CategoryOrderDTO.class);
            dtoList.add(categoryOrderDTO);
        }
        return new ApiResponse<>(true, 200, "success", dtoList);
    }

    @Override
    public ApiResponse<String> updateOrderCategory(CategoryOrderPayload.UpdateCategoryOrderPayload payload) {
        CategoryOrderEntity entity = categoryOrderRepository.findCategoryOrderEntityByCategoryOrderId(payload.getCategoryOrderId());
        entity.setCategoryOrderStatus(payload.getCategoryStatus());
        entity.setCategoryOrderName(payload.getCategoryName());
        categoryOrderRepository.save(entity);
        return new ApiResponse<>(true, 200, "success", "Category is updated");

    }

    @Override
    @Transactional
    public ApiResponse<String> deleteCategoryOrder(CategoryOrderPayload.DeleteCategoryOrderPayload payload) {
        long res = categoryOrderRepository.deleteByCategoryOrderId(payload.getCategoryOrderId());
        if (res == 0) {
            throw new RuntimeException();
        }
        return new ApiResponse<>(true, 200, "success", "Category is deleted");
    }
}
