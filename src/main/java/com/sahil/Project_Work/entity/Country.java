package com.sahil.Project_Work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="country")
public class Country {

    @Id
    @Column(name="cid",unique=true,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long cid;

    @NonNull
    @Column(name="cname")
    String cname;
}
