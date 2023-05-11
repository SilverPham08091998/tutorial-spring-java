package com.example.springjava.service;

import com.example.springjava.model.CategoryOrderDTO;
import com.example.springjava.payload.request.CategoryOrderPayload;
import com.example.springjava.payload.response.ApiResponse;

import java.util.List;

public interface CategoryOrderService {

    ApiResponse<String> createOrderCategory(CategoryOrderPayload.CreateCategoryOrderPayload payload);

    ApiResponse<List<CategoryOrderDTO>> getListCategoryOrder(String search, String filter);

    ApiResponse<String> updateOrderCategory(CategoryOrderPayload.UpdateCategoryOrderPayload payload);

    ApiResponse<String> deleteCategoryOrder(CategoryOrderPayload.DeleteCategoryOrderPayload payload);


}
