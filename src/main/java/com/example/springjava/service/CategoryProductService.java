package com.example.springjava.service;

import com.example.springjava.payload.request.CategoryProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryProductService {
    ResponseEntity<ApiResponse<?>> createProductCategory(CategoryProductPayload.CreateCategoryProductPayload payload);

    ResponseEntity<ApiResponse<?>> getListCategoryProduct(String search, String filter);

    ResponseEntity<ApiResponse<?>> updateProductCategory(CategoryProductPayload.UpdateCategoryProductPayload payload);

    ResponseEntity<ApiResponse<?>> deleteCategoryProduct(CategoryProductPayload.DeleteCategoryProductPayload payload);
}
