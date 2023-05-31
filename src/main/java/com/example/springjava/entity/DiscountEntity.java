package com.example.springjava.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "PRODUCT_DISCOUNT")
@Table(name = "PRODUCT_DISCOUNT")
@Getter
@Setter
public class DiscountEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DISCOUNT_ID", updatable = false, nullable = false)
    private Long discountId;

    @Column(name = "DISCOUNT_TYPE")
    private String discountType;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "RPOVINCE_ID")
    private ProductEntity productEntity;

}
