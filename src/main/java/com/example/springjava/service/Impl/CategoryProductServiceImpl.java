package com.example.springjava.service.Impl;

import com.example.springjava.payload.request.CategoryProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.CategoryProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
    @Override
    public ResponseEntity<ApiResponse<?>> createProductCategory(CategoryProductPayload.CreateCategoryProductPayload payload) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getListCategoryProduct(String search, String filter) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> updateProductCategory(CategoryProductPayload.UpdateCategoryProductPayload payload) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> deleteCategoryProduct(CategoryProductPayload.DeleteCategoryProductPayload payload) {
        return null;
    }
}
