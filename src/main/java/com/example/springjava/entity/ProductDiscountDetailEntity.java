package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PRODUCT_DISCOUNT_DETAIL")
@Table(name = "PRODUCT_DISCOUNT_DETAIL")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDiscountDetailEntity {
    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity productEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "expired_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;

    @Column(name = "discount_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discountDate;

    @Column(name = "status")
    private String status;
}
