package com.unillanos.software3.bestore.services.implementation;

import com.unillanos.software3.bestore.repositories.EnterpriseRepo;
import com.unillanos.software3.bestore.model.entities.Enterprise;
import com.unillanos.software3.bestore.services.interfaces.EnterpriseRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseRepoServiceImpl implements EnterpriseRepoService {

    @Autowired
    private EnterpriseRepo enterpriseRepo;

    @Override
    public List<Enterprise> findAllEnterprises() {
        return  enterpriseRepo.findAll();
    }

    @Override
    public Enterprise saveEnterprise(Enterprise enterprise) {
        return enterpriseRepo.save(enterprise);
    }

    @Override
    public Enterprise EnterpriseById(Long id) {
        return enterpriseRepo.findById(id).get();
    }

    @Override
    public Enterprise UpdateEnterprise(Enterprise enterprise) {
        return enterpriseRepo.save(enterprise);
    }

    @Override
    public boolean DeleteEnterprise(Long id) {
        try {
            enterpriseRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
