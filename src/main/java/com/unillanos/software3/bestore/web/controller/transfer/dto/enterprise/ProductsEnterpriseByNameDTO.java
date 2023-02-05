package com.unillanos.software3.bestore.web.controller.transfer.dto.enterprise;

import com.unillanos.software3.bestore.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsEnterpriseByNameDTO {
    private String nit;
    private String name;
    private String phone;
    private List<Product> productList;

}
