package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "USER")
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private String userId;

    @Column(name = "FULL_NAME")
    private String fullName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "AGE")
    private int age;
    @Column(name = "JOB")
    private String job;

    @Column(name = "RELATION")
    private String relation;

    @Column(name = "ROLE", length = 64)
    private String role;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "TITLE_POSITION")
    private String titlePosition;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ID_CARD", unique = true)
    private String idCard;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "EXPERIED_DATE")
    private String experiedDate;
}
