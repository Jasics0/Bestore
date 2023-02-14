package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.domain.model.entities.Enterprise;
import com.unillanos.software3.bestore.domain.model.entities.Product;
import com.unillanos.software3.bestore.web.transfer.dto.ProductDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseProductsDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.ProductsByNameDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.ProductsEnterpriseByNameDTO;
import com.unillanos.software3.bestore.web.transfer.request.EnterpriseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EnterpriseRepoService {

     List<Enterprise> findAllEnterprises();

     Enterprise saveEnterprise(Enterprise enterprise);

     Enterprise EnterpriseById(Long id);

     Enterprise updateEnterprise(EnterpriseDTO enterprise);

    Product addProduct(ProductDTO product, MultipartFile file);

    Product updateProduct(ProductDTO product, MultipartFile file);

    boolean deleteProduct(String code);

     boolean DeleteEnterprise(Long id);

     List<EnterpriseDescDTO> descEnterprises();

     EnterpriseProductsDTO enterpriseProducts(Long id);

     List<ProductsEnterpriseByNameDTO> productsEnterpriseByName(String name);

     List<ProductsByNameDTO> productsByName(String name);

    Enterprise me();

    boolean uploadImage(MultipartFile file);

    boolean deleteImage();
}
