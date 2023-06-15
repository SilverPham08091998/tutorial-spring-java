package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "COUPON_TYPE")
@Table(name = "COUPON_TYPE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponTypeEntity {
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    UserEntity userEntity;

    @OneToMany(mappedBy = "couponTypeEntity", cascade = CascadeType.ALL)
    private List<CouponEntity> couponEntityList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUPON_TYPE_ID")
    private Long couponTypeId;

    @Column(name = "COUPON_TYPE_NAME")
    private String couponTypeName;

    @Column(name = "COUNPON_TYPE_STATUS")
    private String promotionTypeStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createdDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIE_DATE")
    private Date modifieDate;
}
