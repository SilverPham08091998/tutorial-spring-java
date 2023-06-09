package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Supplier")
@Table(name = "Supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "address")
    private String address;

    @Column(name = "province")
    private int provinceId;

    @Column(name = "district")
    private int districtId;

    @Column(name = "ward")
    private int wardId;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "hotline")
    private String hotline;

    @Column(name = "products")
    private long products;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "banner")
    private String banner;

    @Column(name = "rating")
    private long rating;

    @Column(name = "sold_quantity")
    private long soldQuantity;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "supplierEntity", cascade = CascadeType.ALL)
    private List<PromotionTypeEntity> promotionTypeEntityList;

    @OneToMany(mappedBy = "supplierEntity", cascade = CascadeType.ALL)
    private List<DiscountTypeEntity> discountTypeEntityList;

    @OneToMany(mappedBy = "supplierEntity", cascade = CascadeType.ALL)
    private List<CategoryEntity> categoryEntityList;

}
