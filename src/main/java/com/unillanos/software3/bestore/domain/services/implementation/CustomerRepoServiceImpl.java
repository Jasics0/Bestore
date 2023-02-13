package com.unillanos.software3.bestore.domain.services.implementation;

import com.unillanos.software3.bestore.domain.model.entities.Customer;
import com.unillanos.software3.bestore.domain.model.entities.Person;
import com.unillanos.software3.bestore.domain.services.interfaces.AuthService;
import com.unillanos.software3.bestore.domain.services.interfaces.CustomerRepoService;
import com.unillanos.software3.bestore.infraestructure.repositories.CustomerRepo;
import com.unillanos.software3.bestore.infraestructure.repositories.PersonRepo;
import com.unillanos.software3.bestore.web.transfer.request.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerRepoServiceImpl implements CustomerRepoService {

    private final CustomerRepo costumerRepo;
    private final PersonRepo personRepo;
    private final AuthService authService;

    @Override
    public List<Customer> findAllCostumers() {
        return costumerRepo.findAll();
    }

    @Override
    public Customer saveCostumer(Customer costumer) {
        return costumerRepo.save(costumer);
    }

    @Override
    public Customer CostumerById(Long id) {
        return costumerRepo.findById(id).get();
    }

    @Override
    @Transactional
    public Customer updateCostumer(PersonDTO personDTO) {
        Customer customer = costumerRepo.findByUser(authService.getUser());

        Person person = customer.getPerson();
        if (personDTO.getName() != null) {
            person.setName(personDTO.getName());
        }
        if (personDTO.getLastName() != null) {
            person.setLastName(personDTO.getLastName());
        }
        if (personDTO.getPhone() != null) {
            person.setPhone(personDTO.getPhone());
        }
        customer.setPerson(person);
        return costumerRepo.save(customer);
    }

    @Override
    public boolean DeleteCostumer(Long id) {
        try {
            costumerRepo.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    @Override
    public Customer me() {
        Customer customer = costumerRepo.findByUser(authService.getUser());
        if (customer == null) {
            return null;
        }
        return customer;
    }
}
