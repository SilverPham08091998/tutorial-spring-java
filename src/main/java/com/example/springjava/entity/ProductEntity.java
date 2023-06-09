package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "PRODUCT")
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PRODUCT_ID", updatable = false, nullable = false)
    private Long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PRODUCT_STATUS")
    private String productStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "PRICE")
    private long price;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "STOCK_AVAILABLE")
    private boolean stockAvailable;

    @Column(name = "THUMBNAIL")
    private String thumbnail;

    @Column(name = "sold_quantity")
    private long soldQuantity;

    @Column(name = "rating")
    private long rating;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_PRODUCT_ID")
    private CategoryProductEntity categoryProductEntity;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<ProductDiscountDetailEntity> productDiscountDetailEntityList;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<ProductPromotionDetailEntity> productPromotionDetailEntityList;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private ProductPhoneDetailEntity productPhoneDetailEntity;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private ProductMonitorDetailEntity productMonitorDetailEntity;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private ProductLaptopDetailEntity productLaptopDetailEntity;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private ProductWatchDetailEntity productWatchDetailEntity;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private ProductHeadphoneEntity productHeadphoneEntity;
}
