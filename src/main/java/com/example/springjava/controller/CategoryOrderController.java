package com.example.springjava.controller;


import com.example.springjava.payload.request.CategoryOrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.CategoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category/order")
public class CategoryOrderController {

    @Autowired
    CategoryOrderService categoryOrderService;

    @GetMapping(value = "/list-order")
    public ResponseEntity<ApiResponse<?>> getListCategoryOrder(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "filter", required = false) String filter
    ) {
        try {
            return ResponseEntity.ok(categoryOrderService.getListCategoryOrder(search, filter));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/create-order")
    public ResponseEntity<ApiResponse<String>> createCategoryOrder(@RequestBody CategoryOrderPayload.CreateCategoryOrderPayload payload) {
        try {
            return ResponseEntity.ok(categoryOrderService.createOrderCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping(value = "/update-order")
    public ResponseEntity<ApiResponse<String>> updateCategoryOrder(@RequestBody CategoryOrderPayload.UpdateCategoryOrderPayload payload) {
        try {
            return ResponseEntity.ok(categoryOrderService.updateOrderCategory(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ApiResponse<String>> deleteCategoryOrder(@RequestBody CategoryOrderPayload.DeleteCategoryOrderPayload payload) {
        try {
            return ResponseEntity.ok(categoryOrderService.deleteCategoryOrder(payload));
        } catch (Exception e) {
            throw e;
        }
    }

}
