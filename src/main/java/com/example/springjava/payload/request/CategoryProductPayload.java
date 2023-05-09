package com.example.springjava.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryProductPayload {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateCategoryProductPayload {
        private String categoryProductName;
        private String categoryProductStatus;

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class UpdateCategoryProductPayload {
        private String categoryProductId;
        private String categoryProductName;
        private String categoryProductStatus;

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DeleteCategoryProductPayload {
        private String categoryProductId;


    }
}
