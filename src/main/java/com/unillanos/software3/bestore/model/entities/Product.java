package com.unillanos.software3.bestore.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String code;// UUID.randomUUID().toString().replace("-", "");
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 1500)
    private String description;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String imagePath;
}
