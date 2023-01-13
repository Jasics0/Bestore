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
    @Column(name = "product_id")
    private Long id;
    @Column(unique = true)
    private String code = UUID.randomUUID().toString().replace("-", "");

    private String name;
    private String description;
    private String price;
}
