package com.example.springjava.controller;

import com.example.springjava.model.ProductDTO;
import com.example.springjava.payload.request.ProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@PreAuthorize("hasAnyAuthority('SUPPLIER')")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/list-product/{categoryProductId}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getListProduct(
            @PathVariable(value = "categoryProductId") String categoryProductId,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "filter", required = false) String filter
    ) {
        try {
            return ResponseEntity.ok(productService.getListProduct(search, filter, categoryProductId));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/create-product")
    public ResponseEntity<ApiResponse<String>> createProduct(@RequestBody ProductPayload.CreateProductPayload payload) {
        try {
            ApiResponse<String> response = productService.createProduct(payload);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping(value = "/update-product")
    public ResponseEntity<ApiResponse<String>> updateCategoryProduct(@RequestBody ProductPayload.UpdateProductPayload payload) {
        try {
            return ResponseEntity.ok(productService.updateProduct(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ApiResponse<String>> deleteProduct(ProductPayload.DeleteProductPayload payload) {
        try {
            return ResponseEntity.ok(productService.deleteProduct(payload));
        } catch (Exception e) {
            throw e;
        }
    }
}
