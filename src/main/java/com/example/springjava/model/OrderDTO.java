package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String orderId;

    private String orderName;

    private String orderType;

    private String orderStatus;

    private Date createDate;

    private Date modifiedDate;

    private String productId;

    private BigDecimal amount;

    private BigDecimal totalAmount;

    private String paymentStatus;

    private List<ProductDTO> productDTOList;
}
