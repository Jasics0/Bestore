package com.unillanos.software3.bestore.domain.services.implementation;


import com.unillanos.software3.bestore.domain.model.entities.Enterprise;
import com.unillanos.software3.bestore.domain.model.entities.Product;
import com.unillanos.software3.bestore.domain.services.interfaces.AuthService;
import com.unillanos.software3.bestore.domain.services.interfaces.EnterpriseRepoService;
import com.unillanos.software3.bestore.infraestructure.repositories.EnterpriseRepo;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseProductsDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.ProductsByNameDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.ProductsEnterpriseByNameDTO;
import com.unillanos.software3.bestore.web.transfer.request.EnterpriseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseRepoServiceImpl implements EnterpriseRepoService {

    private final EnterpriseRepo enterpriseRepo;
    private final AuthService authService;

    @Override
    public List<Enterprise> findAllEnterprises() {
        List<Enterprise> enterprises = enterpriseRepo.findAll();

        return enterprises;
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
    public Enterprise updateEnterprise(EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = enterpriseRepo.findByUser(authService.getUser());

        if (enterpriseDTO.getName() != null) {
            enterprise.setName(enterpriseDTO.getName());
        }
        if (enterpriseDTO.getNit() != null) {
            enterprise.setNit(enterpriseDTO.getNit());
        }
        if (enterpriseDTO.getPhone() != null) {
            enterprise.setPhone(enterpriseDTO.getPhone());
        }
        if(enterpriseDTO.getLocation() != null){
            enterprise.setLocation(enterpriseDTO.getLocation());
        }
        if(enterpriseDTO.getImagePath() != null){
            enterprise.setImagePath(enterpriseDTO.getImagePath());
        }
        if(enterpriseDTO.getPerson().getName()!=null){
            enterprise.getPerson().setName(enterpriseDTO.getPerson().getName());
        }
        if(enterpriseDTO.getPerson().getLastName()!=null){
            enterprise.getPerson().setLastName(enterpriseDTO.getPerson().getLastName());
        }
        if(enterpriseDTO.getPerson().getPhone()!=null){
            enterprise.getPerson().setPhone(enterpriseDTO.getPerson().getPhone());
        }
        return enterpriseRepo.save(enterprise);
    }

    @Override
    public boolean DeleteEnterprise(Long id) {
        try {
            enterpriseRepo.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    @Override
    public List<EnterpriseDescDTO> descEnterprises() {
        return enterpriseRepo.descEnterprise();
    }

    @Override
    public EnterpriseProductsDTO enterpriseProducts(Long id) {
        List<Object[]> enterpriseProducts = enterpriseRepo.enterpriseProducts(id);
        EnterpriseProductsDTO enterpriseProductsDTO = new EnterpriseProductsDTO();
        List<Product> productList = new ArrayList<>();


        for (int i = 0; i < enterpriseProducts.size(); i++) {
            Object[] array = enterpriseProducts.get(i);
            for (int j = 0; j < array.length; j++) {
                switch (j) {

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

        return enterpriseProductsDTO;
    }

    @Override
    public List<ProductsEnterpriseByNameDTO> ProductsEnterpriseByName(String name) {
        List<Object[]> enterprises = enterpriseRepo.ProductsEnterpriseByName(name);
        List<ProductsEnterpriseByNameDTO> listDTO = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        ProductsEnterpriseByNameDTO productsEnterpriseByNameDTO = new ProductsEnterpriseByNameDTO();
        String nitAct = "";
        String nitAnt = "";
        //System.out.println(enterpriseRepo.findAll().toString());
        for (int i = 0; i < enterprises.size(); i++) {
            Object[] array = enterprises.get(i);
            nitAct = (String) array[0];

            //System.out.println("anterior: "+nitAnt+" actual: "+nitAct);
            if (!nitAnt.equals(nitAct) && nitAnt.length() != 0) {
                //System.out.println("diferente");
                productsEnterpriseByNameDTO.setProductList(productList);
                listDTO.add(productsEnterpriseByNameDTO);

                productList = new ArrayList<>();
                productsEnterpriseByNameDTO = new ProductsEnterpriseByNameDTO();
            }

            if (i == enterprises.size() - 1) {
                productsEnterpriseByNameDTO.setProductList(productList);
                listDTO.add(productsEnterpriseByNameDTO);
            }


            for (int j = 0; j < array.length; j++) {
                switch (j) {
                    case 0:
                        productsEnterpriseByNameDTO.setNit((String) array[0]);
                        break;
                    case 1:
                        productsEnterpriseByNameDTO.setName((String) array[1]);
                        break;
                    case 2:
                        productsEnterpriseByNameDTO.setPhone((String) array[2]);
                        break;
                    case 3:
                        Product product = (Product) array[3];
                        productList.add(product);
                        break;
                }
            }
            nitAnt = nitAct;

        }


        return listDTO;
    }

    @Override
    public List<ProductsByNameDTO> ProductsByName(String name) {
        List<Object[]> results = enterpriseRepo.ProductsByName(name);
        List<ProductsByNameDTO> productsByNameDTOS = new ArrayList<>();
        for (Object[] result : results) {
            String nit = (String) result[0];
            String enterpriseName = (String) result[1];
            String phone = (String) result[2];
            String code = (String) result[3];
            String productName = (String) result[4];
            String description = (String) result[5];
            String price = (String) result[6];
            String imagePath = (String) result[7];
            productsByNameDTOS.add(new ProductsByNameDTO(nit, enterpriseName, phone, code, productName, description, price, imagePath));
        }
        return productsByNameDTOS;
    }

    @Override
    public Enterprise me() {
        Enterprise enterprise = enterpriseRepo.findByUser(authService.getUser());
        if (enterprise == null) {
            return null;
        }
        return enterprise;

    }
}