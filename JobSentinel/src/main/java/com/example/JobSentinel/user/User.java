package com.example.JobSentinel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Entity
@Table(name = "users")
//this is for the setters and getters and toString to be generated automat
@Data

//this is for constructors, without parameters like public User() {} and with requeird parameters
@NoArgsConstructor
@RequiredArgsConstructor

public class User {

    @Id
    //This is for making the id being generated automat and in order like 1, 2, 3...
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
