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

    @Column(name = "ATI")
    private String ati;

    @Column(name = "TYPE_TOKEN", length = 256)
    private String typeToken;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREADTED_DATE")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRED_DATE")
    private Date expireDate;

    @Column(name = "JWT_ACTIVE")
    private boolean jwtActive;

    @Column(name = "PHONENUMBER", length = 256)
    private String phoneNumber;


    @Column(name = "EMAIL", length = 256)
    private String email;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "USER_NAME")
    private String username;

}
