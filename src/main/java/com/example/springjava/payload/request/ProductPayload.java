package com.example.springjava.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class ProductPayload {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateProductPayload {
        private String categoryProductId;
        private String productName;
        private String productStatus;
        private long amount;
        private String productType;
        private long quantity;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class UpdateProductPayload {
        private String productId;
        private String productName;
        private String productStatus;
        private BigDecimal amount;
        private String productType;
        private String quantity;


    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DeleteProductPayload {
        private String productId;


    }
}
