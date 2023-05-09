package com.example.springjava.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryOrderPayload {


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateCategoryOrderPayload {
        private String categoryName;
        private String categoryStatus;

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class UpdateCategoryOrderPayload {
        private String categoryOrderId;
        private String categoryName;
        private String categoryStatus;

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DeleteCategoryOrderPayload {
        private String categoryOrderId;


    }
}
