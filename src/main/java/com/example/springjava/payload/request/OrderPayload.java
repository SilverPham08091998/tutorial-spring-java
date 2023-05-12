package com.example.springjava.payload.request;

import com.example.springjava.model.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class OrderPayload {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateOrderPayload {

        private String orderName;

        private String categoryOrderId;

        private String orderStatus;

        private String paymentStatus;

        private List<ProductDTO> productDTOList;

        private long discount;

        private String userId;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class UpdateOrderPayload {

        private String orderId;

        private String orderName;

        private String categoryOrderId;

        private String orderStatus;

        private String paymentStatus;

        private List<ProductDTO> productDTOList;

        private long discount;

        private String userId;

    }
}
