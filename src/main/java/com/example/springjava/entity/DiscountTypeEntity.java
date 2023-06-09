package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "DISCOUNT_TYPE_ENTITY")
@Table(name = "DISCOUNT_TYPE_ENTITY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountTypeEntity {
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    SupplierEntity supplierEntity;

    @OneToOne(mappedBy = "discountTypeEntity", cascade = CascadeType.ALL)
    private DiscountEntity discountEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISCOUNT_TYPE_ID")
    private Long promotionTypeId;

    @Column(name = "DISCOUNT_TYPE_NAME")
    private String promotionTypeName;

    @Column(name = "DISCOUNT_TYPE_STATUS")
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
