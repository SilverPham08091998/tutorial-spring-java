package com.example.springjava.service.Impl;

import com.example.springjava.payload.request.CategoryOrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.CategoryOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryOrderServiceImpl implements CategoryOrderService {
    @Override
    public ResponseEntity<ApiResponse<?>> createOrderCategory(CategoryOrderPayload.CreateCategoryOrderPayload payload) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getListCategoryOrder(String search, String filter) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> updateOrderCategory(CategoryOrderPayload.UpdateCategoryOrderPayload payload) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> deleteCategoryOrder(CategoryOrderPayload.DeleteCategoryOrderPayload payload) {
        return null;
    }
}
