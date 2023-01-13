package com.unillanos.software3.bestore.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "id_person",length = 50)
    private String id;
    private String name;
    private String lastName;
    private String phone;

}
