package com.unillanos.software3.bestore.services.interfaces;

import com.unillanos.software3.bestore.model.entities.Enterprise;

import java.util.List;

public interface EnterpriseRepoService {

    public List<Enterprise> findAllEnterprises();

    public Enterprise saveEnterprise(Enterprise enterprise);

    public Enterprise EnterpriseById(Long id);

    public Enterprise UpdateEnterprise(Enterprise enterprise);

    public boolean DeleteEnterprise(Long id);
}
