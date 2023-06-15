package com.example.springjava.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "COUPON")
@Table(name = "COUPON")
@Getter
@Setter
public class CouponEntity {
    @ManyToOne
    @JoinColumn(name = "COUPON_TYPE_ID")
    CouponTypeEntity couponTypeEntity;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COUPON_ID", updatable = false, nullable = false)
    private Long couponId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "MINIMUM_ORDER_VALUE")
    private BigDecimal minimumOrderValue;

    @Column(name = "MAXIMUM_COUPON_AMOUNT")
    private BigDecimal maximumCouponAmount;

    @Column(name = "IS_REDEEM_ALLOWED")
    private boolean isRedeemAllowed;

    @Column(name = "COUPON_CODE")
    private String couponCode;

    @Column(name = "IS_FREE_SHIP")
    private boolean isFreeShip;

    @Column(name = "COUPON_SHIP_AMOUNT")
    private BigDecimal couponShipAmount;

    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "EXPIRED_DATE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;


}
