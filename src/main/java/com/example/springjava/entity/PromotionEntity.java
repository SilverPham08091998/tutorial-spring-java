package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "PROMOTION")
@Table(name = "PROMOTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PROMOTION_ID", updatable = false, nullable = false)
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
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;
}
