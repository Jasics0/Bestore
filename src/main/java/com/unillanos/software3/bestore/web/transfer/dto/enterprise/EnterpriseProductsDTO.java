package com.unillanos.software3.bestore.web.transfer.dto.enterprise;

import com.unillanos.software3.bestore.domain.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EnterpriseProductsDTO {
    private Long id;
    private String nit;
    private String name;
    private List<Product> productList;
    private String location;
    private String imagePath;
    private String phone;


    public EnterpriseProductsDTO() {
    }
}
