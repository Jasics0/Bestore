package com.unillanos.software3.bestore.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "admins")
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="id_person", referencedColumnName = "id_person")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="email_user", referencedColumnName = "email")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

}
