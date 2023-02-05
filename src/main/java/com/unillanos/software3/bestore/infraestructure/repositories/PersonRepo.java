package com.unillanos.software3.bestore.infraestructure.repositories;

import com.unillanos.software3.bestore.domain.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,String> {
}
