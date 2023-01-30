package com.unillanos.software3.bestore.web.controller.enterprise;

import com.unillanos.software3.bestore.domain.services.interfaces.EnterpriseRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseIdDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseRepoService enterpriseService;

    @GetMapping(value="/findAll",produces = "application/json")
    public List<EnterpriseDescDTO> getEnterprises() {
        EnterpriseProductsDTO enterpriseProductsDTO = new EnterpriseProductsDTO();

        return enterpriseService.descEnterprises();
    }

    @PostMapping (value = "/findAllProductsById", produces = "application/json")
    public EnterpriseProductsDTO getById(@RequestBody EnterpriseIdDTO enterpriseIdDTO){

        return enterpriseService.enterpriseProducts(enterpriseIdDTO.getId());
    }
}
