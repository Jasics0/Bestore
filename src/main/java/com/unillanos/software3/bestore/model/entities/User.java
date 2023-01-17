package com.unillanos.software3.bestore.model.entities;

import com.unillanos.software3.bestore.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
@Entity
public class User {
    @Id
    @Column(length = 50)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Role role;

}
