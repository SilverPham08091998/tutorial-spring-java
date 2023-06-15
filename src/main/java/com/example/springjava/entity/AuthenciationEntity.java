package com.example.springjava.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "AUTHENCIATION")
@Table(name = "AUTHENCIATION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthenciationEntity {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userId = UUID.randomUUID().toString();

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "PLATFORM")
    private String platform;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "PASSWORD_CREATED_DATE")
    private Date passwordCreatedDate;

    @Column(name = "WRONG_PASSWORD_DATE")
    private Date wrongPasswordDate;

    @Column(name = "WRONG_PASSWORD_COUNT")
    private int wrongPasswordCount;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(mappedBy = "authenciationEntity", cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private RoleEntity roleEntity;
}
