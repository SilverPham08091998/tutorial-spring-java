package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "ORDER_DETAIL")
@Table(name = "ORDER_DETAIL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailEntity {

    @Id
    @Column(name = "ORDER_DETAIL_ID")
    private String orderDetailId = UUID.randomUUID().toString();

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PRODUCT_STATUS")
    private String productStatus;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "QUANTITY")
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity orderEntity;
}
