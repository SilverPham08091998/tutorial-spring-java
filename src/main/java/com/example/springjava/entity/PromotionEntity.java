package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PROMOTION")
@Table(name = "PROMOTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionEntity {

    @OneToOne
    @JoinColumn(name = "PROMOTION_TYPE_ID")
    PromotionTypeEntity promotionTypeEntity;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PROMOTION_ID", updatable = false, nullable = false)
    private Long discountId;

    @Column(name = "WORD_AMOUNT")
    private String wordAmount;

    @Column(name = "AMOUNT")
    private String amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PRODUCT_GIFT_ID")
    private String productId;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}
