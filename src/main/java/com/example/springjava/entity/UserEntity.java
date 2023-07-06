package com.example.springjava.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "USER_PROFILE")
@Table(name = "USER_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PROFILE_ID", updatable = false, nullable = false)
    private Long profileId;

    @Column(name = "FULL_NAME")
    private String fullName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PROVINE_ID")
    private long provinceId;

    @Column(name = "DISTRICT_ID")
    private long districtId;

    @Column(name = "WARD_ID")
    private long wardId;

    @Column(name = "AGE")
    private int age;

    @Column(name = "JOB")
    private String job;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ID_CARD", unique = true)
    private String idCard;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "EXPERIED_DATE")
    private String experiedDate;

    @Column(name = "RELATIONSHIP")
    private String relationShip;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private AuthenciationEntity authenciationEntity;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private SupplierEntity supplierEntity;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<CouponTypeEntity> couponTypeEntityList;
    
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetailEntityList;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private CartEntity cartEntity;


}
