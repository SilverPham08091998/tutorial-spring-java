package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "ORDER_DETAIL")
@Table(name = "ORDER_DETAIL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailEntity {

    @Id
    @Column(name = "ORDER_ID", unique = true, updatable = false, nullable = false)
    private Long orderId;

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
    @JoinColumn(name = "PRODILE_ID")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderDetailEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;

}
