package com.example.springjava.service;

import com.example.springjava.model.CategoryProductDTO;
import com.example.springjava.payload.request.CategoryProductPayload;
import com.example.springjava.payload.response.ApiResponse;

import java.util.List;

public interface CategoryProductService {
    ApiResponse<String> createProductCategory(CategoryProductPayload.CreateCategoryProductPayload payload);

    ApiResponse<List<CategoryProductDTO>> getListCategoryProduct(String search, String filter, String categoryOrderId);

    ApiResponse<String> updateProductCategory(CategoryProductPayload.UpdateCategoryProductPayload payload);

    ApiResponse<String> deleteCategoryProduct(CategoryProductPayload.DeleteCategoryProductPayload payload);
}
