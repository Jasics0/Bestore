package com.unillanos.software3.bestore.services.interfaces;

import com.unillanos.software3.bestore.model.entities.Costumer;

import java.util.List;

public interface CostumerRepoService {

    public List<Costumer> findAllCostumers();

    public Costumer saveCostumer(Costumer costumer);

    public Costumer CostumerById(Long id);

    public Costumer UpdateCostumer(Costumer costumer);

    public boolean DeleteCostumer(Long id);
}
