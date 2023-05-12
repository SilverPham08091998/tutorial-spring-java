package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDTO {

    private String orderDetailId;

    private String productId;

    private String productName;

    private String productType;

    private String productStatus;

    private long amount;

    private long quantity;
}
