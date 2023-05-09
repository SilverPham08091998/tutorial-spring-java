package com.example.springjava.controller;

import com.example.springjava.payload.request.ProductPayload;
import com.example.springjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/list-product")
    public ResponseEntity<?> getListProduct(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "filter", required = false) String filter
    ) {
        try {
            return ResponseEntity.ok(productService.getListProduct(search, filter));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/create-product")
    public ResponseEntity<?> createProduct(@RequestBody ProductPayload.CreateProductPayload payload) {
        try {
            return ResponseEntity.ok(productService.createProduct(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping(value = "/update-product")
    public ResponseEntity<?> updateCategoryProduct(@RequestBody ProductPayload.UpdateProductPayload payload) {
        try {
            return ResponseEntity.ok(productService.updateProduct(payload));
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteProduct(ProductPayload.DeleteProductPayload payload) {
        try {
            return ResponseEntity.ok(productService.deleteProduct(payload));
        } catch (Exception e) {
            throw e;
        }
    }
}
