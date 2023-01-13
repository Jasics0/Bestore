package com.unillanos.software3.bestore.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nit;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;

    private String location;
}
