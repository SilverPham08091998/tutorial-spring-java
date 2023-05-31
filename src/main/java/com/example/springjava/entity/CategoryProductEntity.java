package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "CATEGORY_PRODUCT")
@Table(name = "CATEGORY_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryProductEntity {

    @Id
    @Column(name = "CATEGORY_PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryProductId;

    @Column(name = "CATEGORY_PRODUCT_NAME")
    private String categoryProductName;

    @Column(name = "CATEGORY_PRODUCT_STATUS")
    private String categoryProductStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "categoryProductEntity", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;
}
