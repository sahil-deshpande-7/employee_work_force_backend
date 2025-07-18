package com.sahil.Project_Work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "password",nullable = false)
    String password;

    @Column(name = "emailid", unique = true, nullable = false)
    private String emailid;

    @Column(name = "gender", unique = true, nullable = false)
    private String gender;

    @Column(name = "mobileno", unique = true, nullable = false)
    private long mobileno;
}
