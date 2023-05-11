package com.example.springjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJavaApplication.class, args);
    }
}
