package com.example.springjava.service;

import com.example.springjava.model.ProductDTO;
import com.example.springjava.payload.request.ProductPayload;
import com.example.springjava.payload.response.ApiResponse;

import java.util.List;

public interface ProductService {
    ApiResponse<String> createProduct(ProductPayload.CreateProductPayload payload);

    ApiResponse<List<ProductDTO>> getListProduct(String search, String filter, String categoryProductId);

    ApiResponse<String> updateProduct(ProductPayload.UpdateProductPayload payload);

    ApiResponse<String> deleteProduct(ProductPayload.DeleteProductPayload payload);
}
