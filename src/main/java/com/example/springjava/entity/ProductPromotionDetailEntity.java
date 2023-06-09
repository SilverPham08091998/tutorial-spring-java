package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PRODUCT_PROMOTION_DETAIL")
@Table(name = "PRODUCT_PROMOTION_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPromotionDetailEntity {
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

    @Column(name = "promotion_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date promotionDate;

    @Column(name = "status")
    private String status;
}
