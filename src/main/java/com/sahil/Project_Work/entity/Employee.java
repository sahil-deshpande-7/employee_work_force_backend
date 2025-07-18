package com.sahil.Project_Work.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    private String name;

//    @NonNull
//    @Column(name = "gender", nullable = true)
//    private String gender;

    @Column(name = "phoneno", unique = true, nullable = false)
    private String phoneno;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "status", nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddtm", nullable = false)
    private Date createddtm;

    @Column(name = "createdby", nullable = false)
    private String createdby;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateddtm", nullable = false)
    private Date updateddtm;


    @Column(name = "updatedby", nullable = false)
    private String updatedby;

//    @Column(name = "emailid", unique = true)
//    private String emailid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    private Country country;

}
