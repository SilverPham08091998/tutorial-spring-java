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
    @Column(name = "JTI")
    private String jti;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ATI")
    private String ati;

    @Column(name = "EXPIRED_STATUS")
    private String expireStatus;

    @Column(name = "EXPERED_DATE")
    private Date expireDate;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "TYPE_TOKEN")
    private String typeToken;

    @Column(name = "USER_NAME")
    private String username;

}
