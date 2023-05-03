package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "AUTHENCIATION")
@Table(name = "AUTHENCIATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenciationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "USERNAME", unique = true)
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

    @Column(name = "AUTHENCIATION_DATE")
    private String authenciationDate;

    @Column(name = "USER_ID")
    private String userId;
}
