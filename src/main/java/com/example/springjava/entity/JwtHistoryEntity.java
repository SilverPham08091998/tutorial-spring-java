package com.example.springjava.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "JWT_HISTORY")
@Table(name = "JWT_HISTORY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JwtHistoryEntity {

    @Id
    @Column(name = "JTI")
    private String jti;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ati")
    private String ati;

    @Column(name = "type_token", length = 256)
    private String typeToken;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_Date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "jwt_active")
    private boolean jwtActive;

    @Column(name = "phoneNumber", length = 256)
    private String phoneNumber;


    @Column(name = "email", length = 256)
    private String email;

    @Column(name = "device_ID")
    private String deviceId;

}
