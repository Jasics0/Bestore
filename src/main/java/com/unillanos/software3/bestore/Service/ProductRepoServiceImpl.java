package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.Repository.ProductRepo;
import com.unillanos.software3.bestore.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductRepoServiceImpl implements ProductRepoService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product ProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product UpdateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public boolean DeleteProduct(Long id) {
        try {
            productRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
