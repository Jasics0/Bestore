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
    @JoinColumn(name ="id_person", referencedColumnName = "id_person")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="email_user", referencedColumnName = "email")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;

    private String location;
}
