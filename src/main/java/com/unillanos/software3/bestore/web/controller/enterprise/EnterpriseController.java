package com.unillanos.software3.bestore.web.controller.enterprise;


import com.unillanos.software3.bestore.domain.services.interfaces.EnterpriseRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.*;
import com.unillanos.software3.bestore.web.transfer.mapper.Mapper;
import com.unillanos.software3.bestore.web.transfer.request.EnterpriseDTO;
import com.unillanos.software3.bestore.web.transfer.responses.ResponseBestore;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseRepoService enterpriseService;

    @GetMapping(value = "/findAll", produces = "application/json")
    public List<EnterpriseDescDTO> getEnterprises() {
        EnterpriseProductsDTO enterpriseProductsDTO = new EnterpriseProductsDTO();

        return enterpriseService.descEnterprises();
    }

    @PostMapping(value = "/findAllProductsById", produces = "application/json")
    public EnterpriseProductsDTO getById(@RequestBody EnterpriseIdDTO enterpriseIdDTO) {

        return enterpriseService.enterpriseProducts(enterpriseIdDTO.getId());
    }

    @PostMapping(value = "/findProductsByEnterpriseName", produces = "application/json")
    public List<ProductsEnterpriseByNameDTO> enterpriseInfoByName(@RequestBody EnterpriseNameDTO enterprise) {

        return enterpriseService.ProductsEnterpriseByName(enterprise.getName());
    }

    @PostMapping (value = "/findProductsByName", produces = "application/json")
    public List<ProductsByNameDTO> ProdusctsByname(@RequestBody ProductNameDTO productNameDTO){
        //System.out.println(productNameDTO.getName());
        return enterpriseService.ProductsByName(productNameDTO.getName());
    }


    @PutMapping(value = "/update", produces = "application/json")
    public ResponseBestore updateEnterprise(@RequestBody EnterpriseDTO enterprise, HttpServletResponse response) {
        EnterpriseDTO enterpriseDTO = Mapper.map(enterpriseService.updateEnterprise(enterprise), EnterpriseDTO.class);
        if (enterpriseDTO != null) {
            return new ResponseBestore(200, "Enterprise updated", enterpriseDTO);
        } else {
            response.setStatus(404);
            return new ResponseBestore(404, "Enterprise not found", null);

        }
    }

    @GetMapping(value = "/me", produces = "application/json")
    public ResponseBestore me() {
        EnterpriseDTO enterprise = Mapper.map(enterpriseService.me(), EnterpriseDTO.class);
        if (enterprise != null) {
            return new ResponseBestore(200, "Enterprise retrieved", enterprise);
        } else {
            return new ResponseBestore(404, "Enterprise not found", null);
        }
    }
}
