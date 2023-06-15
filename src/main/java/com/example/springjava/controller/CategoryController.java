package com.example.springjava.controller;


import com.example.springjava.payload.request.CategoryPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
@PreAuthorize("hasAnyAuthority('SUPPLIER')")

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/list-category")
    public ResponseEntity<ApiResponse<?>> getListCategory(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "filter", required = false) String filter
    ) {
        try {
            return ResponseEntity.ok(categoryService.getListCategory(search, filter));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/create-category")
    public ResponseEntity<ApiResponse<String>> createCategoryOrder(@RequestBody CategoryPayload.CreateCategoryPayload payload) {
        try {
            return ResponseEntity.ok(categoryService.createCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping(value = "/update-category")
    public ResponseEntity<ApiResponse<String>> updateCategoryOrder(@RequestBody CategoryPayload.UpdateCategoryPayload payload) {
        try {
            return ResponseEntity.ok(categoryService.updateCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(value = "/delete-category")
    public ResponseEntity<ApiResponse<String>> deleteCategoryOrder(@RequestBody CategoryPayload.DeleteCategoryPayload payload) {
        try {
            return ResponseEntity.ok(categoryService.deleteCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

}
