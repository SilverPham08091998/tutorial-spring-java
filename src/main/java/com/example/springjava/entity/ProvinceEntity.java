package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "PROVINCE")
@Table(name = "PROVINCE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceEntity {
    @Id
    @Column(name = "PROVINCE_ID")
    private Long provinceId;

    @Column(name = "PROVINCE_NAME")
    private String provinceName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createdDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIE_DATE")
    private Date modifieDate;

    @OneToMany(mappedBy = "provinceEntity", cascade = CascadeType.ALL)
    private List<DistrictEntity> districtEntityList;
}
