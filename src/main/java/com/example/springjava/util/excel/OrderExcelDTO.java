package com.example.springjava.util.excel;

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
public class OrderExcelDTO {
    private String orderId;

    private String orderName;

    private String orderType;

    private String orderStatus;

    private Date createDate;

    private Date modifiedDate;

    private BigDecimal amount;

    private BigDecimal totalAmount;

    private String paymentStatus;

    private int quantity;

    private String productName;

}
