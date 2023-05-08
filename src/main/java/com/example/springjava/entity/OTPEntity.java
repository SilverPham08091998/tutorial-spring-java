package com.example.springjava.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "OTP")
@Entity(name = "OTP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OTPEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OTP_ID")
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATED_ID")
    private Date createdDate;

    @Column(name = "EXPIRED_DATE")
    private Date expiredDate;

    @Column(name = "OTP", length = 6)
    private String otp;

    @Column(name = "COUNT_WRONG_OTP")
    private int countWrongOTP;

    @Column(name = "RESEND_DATE")
    private Date resendDate;

    @Column(name = "MATCHING")
    private boolean matching;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;
}
