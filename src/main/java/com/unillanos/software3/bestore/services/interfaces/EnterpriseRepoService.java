package com.unillanos.software3.bestore.services.interfaces;

import com.unillanos.software3.bestore.model.entities.Enterprise;
import com.unillanos.software3.bestore.web.controller.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.controller.transfer.dto.enterprise.EnterpriseProductsDTO;
import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Objects;

public interface EnterpriseRepoService {

    public List<EnterpriseDescDTO> findAllEnterprises();

    public Enterprise saveEnterprise(Enterprise enterprise);

    public Enterprise EnterpriseById(Long id);

    public Enterprise UpdateEnterprise(Enterprise enterprise);

    public boolean DeleteEnterprise(Long id);

    public List<EnterpriseDescDTO> descEnterprises();

    public EnterpriseProductsDTO enterpriseProducts( Long id);


}
