package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "WARD")
@Table(name = "WARD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WardEntity {
    @Id
    @Column(name = "WARD_ID")
    private Long wardId;

    @Column(name = "WARD_NAME")
    private String wardName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createdDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIE_DATE")
    private Date modifieDate;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_ID")
    private DistrictEntity districtEntity;
}
