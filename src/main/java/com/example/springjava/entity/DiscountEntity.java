package com.example.springjava.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "PRODUCT_DISCOUNT")
@Table(name = "PRODUCT_DISCOUNT")
@Getter
@Setter
public class DiscountEntity {

    @OneToOne
    @JoinColumn(name = "DISCOUNT_TYPE_ID")
    DiscountTypeEntity discountTypeEntity;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DISCOUNT_ID", updatable = false, nullable = false)
    private Long discountId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "WORD_AMOUNT")
    private String wordAmount;

    @Column(name = "QUANITY_PRODUCT")
    private BigDecimal quantityProduct;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PRODUCT_GIFT_ID")
    private String productId;

    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


}
