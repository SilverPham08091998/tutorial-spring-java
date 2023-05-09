package com.example.springjava.service;

import com.example.springjava.payload.request.CategoryOrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryOrderService {

    ResponseEntity<ApiResponse<?>> createOrderCategory(CategoryOrderPayload.CreateCategoryOrderPayload payload);

    ResponseEntity<ApiResponse<?>> getListCategoryOrder(String search, String filter);

    ResponseEntity<ApiResponse<?>> updateOrderCategory(CategoryOrderPayload.UpdateCategoryOrderPayload payload);

    ResponseEntity<ApiResponse<?>> deleteCategoryOrder(CategoryOrderPayload.DeleteCategoryOrderPayload payload);


}
