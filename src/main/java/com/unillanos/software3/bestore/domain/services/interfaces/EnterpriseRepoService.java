package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.domain.model.entities.Enterprise;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseProductsDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.ProductsEnterpriseByNameDTO;
import com.unillanos.software3.bestore.web.transfer.request.EnterpriseDTO;

import java.util.List;

public interface EnterpriseRepoService {

    public List<Enterprise> findAllEnterprises();

    public Enterprise saveEnterprise(Enterprise enterprise);

    public Enterprise EnterpriseById(Long id);

    public Enterprise updateEnterprise(EnterpriseDTO enterprise);

    public boolean DeleteEnterprise(Long id);

    public List<EnterpriseDescDTO> descEnterprises();

    public EnterpriseProductsDTO enterpriseProducts(Long id);

    public List<ProductsEnterpriseByNameDTO> ProductsEnterpriseByName(String name);

    Enterprise me();


}
