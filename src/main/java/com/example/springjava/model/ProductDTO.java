package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String productId;

    private String productName;

    private String productType;

    private String productStatus;

    private long amount;

    private long quantity;


}
