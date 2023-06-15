package com.example.springjava.controller;


import com.example.springjava.model.CategoryProductDTO;
import com.example.springjava.payload.request.CategoryProductPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.CategoryProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category/product")
@PreAuthorize("hasAnyAuthority('SUPPLIER')")
public class CategoryProductController {
    private final Logger logger = LogManager.getLogger(CategoryProductController.class);


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
            logger.error(e);
            throw e;
        }
    }

    @PostMapping(value = "/create-product")
    public ResponseEntity<ApiResponse<String>> createCategoryProduct(@RequestBody CategoryProductPayload.CreateCategoryProductPayload payload) {
        try {
            return ResponseEntity.ok(categoryProductService.createProductCategory(payload));
        } catch (Exception e) {
            logger.error(e);

            throw e;
        }
    }

    @PutMapping(value = "/update-product")
    public ResponseEntity<ApiResponse<String>> updateCategoryProduct(@RequestBody CategoryProductPayload.UpdateCategoryProductPayload payload) {
        try {
            return ResponseEntity.ok(categoryProductService.updateProductCategory(payload));
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteCategoryProduct(CategoryProductPayload.DeleteCategoryProductPayload payload) {
        try {
            return ResponseEntity.ok(categoryProductService.deleteCategoryProduct(payload));
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }
}
