package com.example.springjava.model;

import com.example.springjava.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long id;

    private UserEntity userEntity;

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
}
