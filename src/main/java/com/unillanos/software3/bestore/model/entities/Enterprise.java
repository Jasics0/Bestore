package com.unillanos.software3.bestore.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String nit;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Product> products;

    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String imagePath;
    @Column(nullable = false,length = 10)
    private String phone;


}
