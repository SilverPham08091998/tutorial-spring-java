package com.example.springjava.service.Impl;

import com.example.springjava.payload.request.ProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ResponseEntity<ApiResponse<?>> createProduct(ProductPayload.CreateProductPayload payload) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getListProduct(String search, String filter) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> updateProduct(ProductPayload.UpdateProductPayload payload) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> deleteProduct(ProductPayload.DeleteProductPayload payload) {
        return null;
    }
}
