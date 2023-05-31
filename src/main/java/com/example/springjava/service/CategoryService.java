package com.example.springjava.service;

import com.example.springjava.model.CategoryDTO;
import com.example.springjava.payload.request.CategoryPayload;
import com.example.springjava.payload.response.ApiResponse;

import java.util.List;

public interface CategoryService {

    ApiResponse<String> createCategory(CategoryPayload.CreateCategoryPayload payload);

    ApiResponse<List<CategoryDTO>> getListCategory(String search, String filter);

    ApiResponse<String> updateCategory(CategoryPayload.UpdateCategoryPayload payload);

    ApiResponse<String> deleteCategory(CategoryPayload.DeleteCategoryPayload payload);


}
