package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.model.entities.Admin;
import com.unillanos.software3.bestore.model.entities.Person;

import java.util.List;

public interface PersonRepoService {

    public List<Person> findAllPersons();

    public Person savePerson(Person person);

    public Person PersonById(String id);

    public Person UpdatePerson(Person person);

    public boolean DeletePerson(String id);
}
