package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PROMOTION_TYPE")
@Table(name = "PROMOTION_TYPE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionTypeEntity {

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    SupplierEntity supplierEntity;

    @OneToOne(mappedBy = "promotionTypeEntity", cascade = CascadeType.ALL)
    private PromotionEntity promotionEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROMOTION_TYPE_ID")
    private Long promotionTypeId;

    @Column(name = "PROMOTION_TYPE_NAME")
    private String promotionTypeName;

    @Column(name = "PROMOTION_TYPE_STATUS")
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
