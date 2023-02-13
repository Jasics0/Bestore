package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.domain.model.entities.Customer;
import com.unillanos.software3.bestore.web.transfer.request.PersonDTO;

import java.util.List;

public interface CustomerRepoService {

    List<Customer> findAllCostumers();

    Customer saveCostumer(Customer costumer);

    Customer CostumerById(Long id);

    Customer updateCostumer(PersonDTO costumer);

    boolean DeleteCostumer(Long id);

    Customer me();
}
