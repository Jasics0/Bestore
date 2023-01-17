package com.unillanos.software3.bestore.services.implementation;

import com.unillanos.software3.bestore.repositories.PersonRepo;
import com.unillanos.software3.bestore.model.entities.Person;
import com.unillanos.software3.bestore.services.interfaces.PersonRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRepoServiceImpl  implements PersonRepoService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public List<Person> findAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person PersonById(String id) {
        return personRepo.findById(id).get();
    }

    @Override
    public Person UpdatePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public boolean DeletePerson(String id) {
        try {
            personRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
