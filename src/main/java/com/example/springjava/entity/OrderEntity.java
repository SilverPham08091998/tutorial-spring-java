package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "ORDER_INFORMATION")
@Table(name = "ORDER_INFORMATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ORDER_ID", unique = true, updatable = false, nullable = false)
    private String orderId = UUID.randomUUID().toString();

    @Column(name = "ORDER_NAME")
    private String orderName;

    @Column(name = "ORDER_TYPE")
    private String orderType;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "PRODUCT_IDS")
    private String productId;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "TOTAL_AMOUNT")
    private long totalAmount;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

}
