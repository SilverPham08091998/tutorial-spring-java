package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "ORDER_INFORMATION")
@Table(name = "ORDER_INFORMATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @Column(name = "ORDER_ID", unique = true, updatable = false, nullable = false)
    private String orderId = UUID.randomUUID().toString();

    @Column(name = "ORDER_NAME")
    private String orderName;

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

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "TOTAL_AMOUNT")
    private long totalAmount;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AuthenciationEntity authenciationEntity;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ORDER_ID")
    private CategoryOrderEntity categoryOrderEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetailEntities;

}
