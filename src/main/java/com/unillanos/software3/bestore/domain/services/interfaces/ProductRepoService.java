package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.domain.model.entities.Product;

import java.util.List;

public interface ProductRepoService {

    public List<Product> findAllProducts();

    public Product saveProduct(Product product);

    public Product ProductById(Long id);

    public Product UpdateProduct(Product product);

    public boolean DeleteProduct(Long id);
}
