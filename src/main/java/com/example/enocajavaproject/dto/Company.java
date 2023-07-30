package com.example.enocajavaproject.dto;


import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String company_name;

    @Column
    private String address;

    @Column
    private String industry_type;
}
