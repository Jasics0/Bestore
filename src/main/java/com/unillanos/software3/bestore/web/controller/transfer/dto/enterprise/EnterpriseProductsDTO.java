package com.unillanos.software3.bestore.web.controller.transfer.dto.enterprise;

import com.unillanos.software3.bestore.model.entities.Person;
import com.unillanos.software3.bestore.model.entities.Product;
import com.unillanos.software3.bestore.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
