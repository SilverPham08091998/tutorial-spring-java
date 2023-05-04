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

    @Column(name = "ROLE", length = 64)
    private String role;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(mappedBy = "authenciationEntity", cascade = CascadeType.ALL)
    private UserEntity userEntity;

}
