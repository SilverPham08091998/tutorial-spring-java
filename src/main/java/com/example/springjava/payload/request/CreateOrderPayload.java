package com.example.springjava.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderPayload {

    private String orderName;

    private String orderType;

    private String orderStatus;

    private String productId;

    private BigDecimal amount;

    private BigDecimal totalAmount;

    private String paymentStatus;
}
