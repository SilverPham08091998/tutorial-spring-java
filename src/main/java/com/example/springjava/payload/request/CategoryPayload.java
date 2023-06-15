package com.example.springjava.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryPayload {


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateCategoryPayload {
        private String categoryName;
        private String categoryStatus;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class UpdateCategoryPayload {
        private String categoryId;
        private String categoryName;
        private String categoryStatus;

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DeleteCategoryPayload {
        private String categoryId;


    }
}
