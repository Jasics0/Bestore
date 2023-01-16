package com.unillanos.software3.bestore.model.entities;

import com.unillanos.software3.bestore.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(length = 50)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Role role;

}
