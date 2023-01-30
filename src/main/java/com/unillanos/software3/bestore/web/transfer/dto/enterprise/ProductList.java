package com.unillanos.software3.bestore.web.transfer.dto.enterprise;

import com.unillanos.software3.bestore.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductList {
    private List<Product>  products;
}
