package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "USER")
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

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

    @Column(name = "USER_ID", unique = true)
    private String userId = UUID.randomUUID().toString();

}
