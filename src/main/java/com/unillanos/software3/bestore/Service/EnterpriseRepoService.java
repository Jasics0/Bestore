package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.model.entities.Enterprise;

import java.util.ArrayList;
import java.util.List;

public interface EnterpriseRepoService {

    public List<Enterprise> findAllEnterprises();

    public Enterprise saveEnterprise(Enterprise enterprise);

    public Enterprise EnterpriseById(Long id);

    public Enterprise UpdateEnterprise(Enterprise enterprise);

    public boolean DeleteEnterprise(Long id);
}
