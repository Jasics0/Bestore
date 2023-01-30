package com.unillanos.software3.bestore.domain.services.implementation;

import com.unillanos.software3.bestore.domain.model.entities.Costumer;
import com.unillanos.software3.bestore.domain.services.interfaces.CostumerRepoService;
import com.unillanos.software3.bestore.infraestructure.repositories.CostumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CostumerRepoServiceImpl implements CostumerRepoService {

    @Autowired
    private CostumerRepo costumerRepo;
    @Override
    public List<Costumer> findAllCostumers() {
        return costumerRepo.findAll();
    }

    @Override
    public Costumer saveCostumer(Costumer costumer) {
        return costumerRepo.save(costumer);
    }

    @Override
    public Costumer CostumerById(Long id) {
        return costumerRepo.findById(id).get();
    }

    @Override
    public Costumer UpdateCostumer(Costumer costumer) {
        return costumerRepo.save(costumer);
    }

    @Override
    public boolean DeleteCostumer(Long id) {
        try {
            costumerRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
