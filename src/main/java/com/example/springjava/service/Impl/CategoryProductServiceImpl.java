package com.example.springjava.service.Impl;

import com.example.springjava.entity.CategoryEntity;
import com.example.springjava.entity.CategoryProductEntity;
import com.example.springjava.model.CategoryProductDTO;
import com.example.springjava.payload.request.CategoryProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.CategoryProductRepository;
import com.example.springjava.respository.CategoryRepository;
import com.example.springjava.service.CategoryProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Autowired
    CategoryRepository categoryOrderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public ApiResponse<String> createProductCategory(CategoryProductPayload.CreateCategoryProductPayload payload) {
        CategoryEntity categoryOrder = categoryOrderRepository.findCategoryEntitiesByCategoryId(Long.parseLong(payload.getCategoryOrderId()));
        CategoryProductEntity categoryProduct = new CategoryProductEntity();
        categoryProduct.setCategoryProductName(payload.getCategoryProductName());
        categoryProduct.setCategoryProductStatus(payload.getCategoryProductStatus());
        categoryProduct.setCategoryEntity(categoryOrder);
        categoryProductRepository.save(categoryProduct);
        return new ApiResponse<>(true, 200, "success", "Category product is created");
    }

    @Override
    public ApiResponse<List<CategoryProductDTO>> getListCategoryProduct(String search, String filter, String categoryOrderId) {
        List<CategoryProductEntity> entityList = categoryProductRepository.findCategoryProductEntityByCategoryEntity_CategoryId(Long.valueOf(categoryOrderId));
        List<CategoryProductDTO> dtoList = new ArrayList<>();
        for (CategoryProductEntity entity : entityList) {
            CategoryProductDTO categoryProductDTO = modelMapper.map(entity, CategoryProductDTO.class);
            dtoList.add(categoryProductDTO);
        }
        return new ApiResponse<>(true, 200, "success", dtoList);
    }

    @Override
    public ApiResponse<String> updateProductCategory(CategoryProductPayload.UpdateCategoryProductPayload payload) {
        return null;
    }

    @Override
    public ApiResponse<String> deleteCategoryProduct(CategoryProductPayload.DeleteCategoryProductPayload payload) {
        return null;
    }
}
