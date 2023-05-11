package com.example.springjava.controller;


import com.example.springjava.model.CategoryProductDTO;
import com.example.springjava.payload.request.CategoryProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category/product")
public class CategoryProductController {

    @Autowired
    CategoryProductService categoryProductService;

    @GetMapping(value = "/list-product/{categoryOrderId}")
    public ResponseEntity<ApiResponse<List<CategoryProductDTO>>> getListCategoryProduct(
            @PathVariable(value = "categoryOrderId") String categoryOrderId,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "filter", required = false) String filter
    ) {
        try {
            return ResponseEntity.ok(categoryProductService.getListCategoryProduct(search, filter, categoryOrderId));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/create-product")
    public ResponseEntity<ApiResponse<String>> createCategoryProduct(@RequestBody CategoryProductPayload.CreateCategoryProductPayload payload) {
        try {
            return ResponseEntity.ok(categoryProductService.createProductCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping(value = "/update-product")
    public ResponseEntity<ApiResponse<String>> updateCategoryProduct(@RequestBody CategoryProductPayload.UpdateCategoryProductPayload payload) {
        try {
            return ResponseEntity.ok(categoryProductService.updateProductCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteCategoryProduct(CategoryProductPayload.DeleteCategoryProductPayload payload) {
        try {
            return ResponseEntity.ok(categoryProductService.deleteCategoryProduct(payload));
        } catch (Exception e) {
            throw e;
        }
    }
}
