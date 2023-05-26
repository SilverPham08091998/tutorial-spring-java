package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderFilter {

    private String userId;

    private String orderId;

    private String orderName;

    private String orderType;

    private String orderStatus;

    private String createDate;

    private String modifiedDate;

    private Integer amount;

    private Integer totalAmount;

    private String paymentStatus;
}
