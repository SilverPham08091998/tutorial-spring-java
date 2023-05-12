package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity(name = "CATEGORY_ORDER")
@Table(name = "CATEGORY_ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryOrderEntity {
    @Id
    @Column(name = "CATEGORY_ORDER_ID")
    private String categoryOrderId = UUID.randomUUID().toString();

    @Column(name = "CATEGORY_ORDER_NAME")
    private String categoryOrderName;

    @Column(name = "CATEGORY_ORDER_STATUS")
    private String categoryOrderStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @OneToMany(mappedBy = "categoryOrderEntity", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntityList;

    @OneToMany(mappedBy = "categoryOrderEntity", cascade = CascadeType.ALL)
    private List<CategoryProductEntity> categoryProductEntities;


}
