package com.unillanos.software3.bestore.domain.services.implementation;

import com.unillanos.software3.bestore.domain.model.entities.Enterprise;
import com.unillanos.software3.bestore.domain.model.entities.Product;
import com.unillanos.software3.bestore.infraestructure.repositories.EnterpriseRepo;
import com.unillanos.software3.bestore.domain.services.interfaces.EnterpriseRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseRepoServiceImpl implements EnterpriseRepoService {

    @Autowired
    private EnterpriseRepo enterpriseRepo;

    @Override
    public List<EnterpriseDescDTO> findAllEnterprises() {
        List <Enterprise> enterprises = enterpriseRepo.findAll();

        List<EnterpriseDescDTO> enterpriseDescDTOList = new ArrayList<>();
        enterprises.forEach((x)->{
                    EnterpriseDescDTO enterpriseDescDTO = new EnterpriseDescDTO (x.getId(),x.getNit(),x.getName(),x.getImagePath(),x.getPhone());
                    enterpriseDescDTOList.add(enterpriseDescDTO);
        }
        );
        return enterpriseDescDTOList;
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

    @Override
    public List<EnterpriseDescDTO> descEnterprises() {
        return enterpriseRepo.descEnterprise();
    }

    @Override
    public EnterpriseProductsDTO enterpriseProducts(Long id) {
        List <Object[]> enterpriseProducts = enterpriseRepo.enterpriseProducts(id);
        EnterpriseProductsDTO enterpriseProductsDTO = new EnterpriseProductsDTO();
        List<Product> productList = new ArrayList<>();


        for (int i =0; i<enterpriseProducts.size();i++){
            Object[] array = enterpriseProducts.get(i);
            for (int j=0; j<array.length;j++){
                switch (j){

                    case 0:
                        enterpriseProductsDTO.setId((Long) array[0]);
                        break;
                    case 1:
                        enterpriseProductsDTO.setNit((String) array[1]);
                        break;
                    case 2:
                        enterpriseProductsDTO.setName((String) array[2]);
                        break;
                    case 3:
                        Product product = (Product) array[3];
                        productList.add(product);
                        break;
                    case 4:
                        enterpriseProductsDTO.setLocation((String) array[4]);
                        break;
                    case 5:
                        enterpriseProductsDTO.setImagePath((String) array[5]);
                        break;
                    case 6:
                        enterpriseProductsDTO.setPhone((String) array[6]);
                        break;
                }
            }


        }

        enterpriseProductsDTO.setProductList(productList);

        return enterpriseProductsDTO ;
    }


}
