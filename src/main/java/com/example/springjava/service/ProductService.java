package com.example.springjava.service;

import com.example.springjava.payload.request.ProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<ApiResponse<?>> createProduct(ProductPayload.CreateProductPayload payload);

    ResponseEntity<ApiResponse<?>> getListProduct(String search, String filter);

    ResponseEntity<ApiResponse<?>> updateProduct(ProductPayload.UpdateProductPayload payload);

    ResponseEntity<ApiResponse<?>> deleteProduct(ProductPayload.DeleteProductPayload payload);
}
