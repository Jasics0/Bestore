package com.unillanos.software3.bestore.domain.model.entities;


import jakarta.persistence.*;
import lombok.*;


import java.util.List;
@Builder
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
    @Column()
    private String location;
    @Column()
    private String imagePath;
    @Column(nullable = false,length = 10)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Product> products;




}
