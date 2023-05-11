package com.example.springjava.payload.request;

import com.example.springjava.model.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

public class OrderPayload {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateOrderPayload {

        private String orderName;

        private String orderType;

        private String orderStatus;
        
        private String paymentStatus;

        private BigDecimal amount;

        private BigDecimal totalAmount;

        private List<ProductDTO> productDTOList;

    }
}
