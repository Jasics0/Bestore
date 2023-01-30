package com.unillanos.software3.bestore.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Setter
@Getter
@Entity
@Table(name = "products")
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

    public Product(Long id, String code, String name, String description, String price, String imagePath) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }

    public Product() {
    }
}
