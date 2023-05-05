package com.example.springjava.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "JWT_EXPIRE")
@Table(name = "JWT_EXPIRE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JWTExpireEntity {
    @Id
    @Column(name = "jti")
    private String jti;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "ati")
    private String ati;

    @Column(name = "expire_status")
    private String expireStatus;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "device_Id")
    private String deviceId;

    @Column(name = "type_token")
    private String typeToken;

}
