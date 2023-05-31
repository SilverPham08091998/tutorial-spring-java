package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "DISTRICT")
@Table(name = "DISTRICT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictEntity {
    @Id
    @Column(name = "DISTRICT_ID")
    private Long roleId;

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DISTRICT_NAME")
    private String roleName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createdDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIE_DATE")
    private Date modifieDate;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_ID")
    private ProvinceEntity provinceEntity;

    @OneToMany(mappedBy = "districtEntity", cascade = CascadeType.ALL)
    private List<WardEntity> wardEntityList;
}
