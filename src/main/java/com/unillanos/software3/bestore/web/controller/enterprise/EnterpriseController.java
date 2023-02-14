package com.unillanos.software3.bestore.web.controller.enterprise;


import com.unillanos.software3.bestore.domain.services.interfaces.EnterpriseRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.ProductDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.*;
import com.unillanos.software3.bestore.web.transfer.mapper.Mapper;
import com.unillanos.software3.bestore.web.transfer.request.EnterpriseDTO;
import com.unillanos.software3.bestore.web.transfer.responses.ResponseBestore;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
@RequiredArgsConstructor
public class EnterpriseController {
    private final EnterpriseRepoService enterpriseService;


    @PostMapping(value = "/uploadImage", consumes = "multipart/form-data", produces = "application/json")
    public ResponseBestore uploadFile(@RequestPart(value = "image") MultipartFile file) {
        if (enterpriseService.uploadImage(file)) {
            return new ResponseBestore(200, "File uploaded", null);
        } else {
            return new ResponseBestore(404, "File not found", null);
        }
    }

    @DeleteMapping(value = "/deleteImage", produces = "application/json")
    public ResponseBestore deleteImage() {
        if (enterpriseService.deleteImage()) {
            return new ResponseBestore(200, "File deleted", null);
        } else {
            return new ResponseBestore(404, "File not found", null);
        }
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public List<EnterpriseDescDTO> getEnterprises() {
        return enterpriseService.descEnterprises();
    }

    @PostMapping(value = "/findAllProductsById", produces = "application/json")
    public EnterpriseProductsDTO getById(@RequestBody EnterpriseIdDTO enterpriseIdDTO) {

        return enterpriseService.enterpriseProducts(enterpriseIdDTO.getId());
    }

    @PostMapping(value = "/findProductsByEnterpriseName", produces = "application/json")
    public List<ProductsEnterpriseByNameDTO> enterpriseInfoByName(@RequestBody EnterpriseNameDTO enterprise) {
        return enterpriseService.productsEnterpriseByName(enterprise.getName());
    }

    @PostMapping(value = "/findProductsByName", produces = "application/json")
    public List<ProductsByNameDTO> productsName(@RequestBody ProductNameDTO productNameDTO) {
        //System.out.println(productNameDTO.getName());
        return enterpriseService.productsByName(productNameDTO.getName());
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

    @PostMapping(value = "/addProduct", produces = "application/json")
    public ResponseBestore addProduct(@RequestParam String name, @RequestParam String description, @RequestParam String price, @RequestPart(value = "image") MultipartFile file, HttpServletResponse response) {
        ProductDTO product = new ProductDTO();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        product = Mapper.map(enterpriseService.addProduct(product, file), ProductDTO.class);

        if (product != null) {
            return new ResponseBestore(200, "Product added", product);
        } else {
            response.setStatus(404);
            return new ResponseBestore(404, "Product not found", null);
        }
    }

    @PutMapping(value = "/updateProduct", produces = "application/json")
    public ResponseBestore updateProduct(@RequestParam String code, @RequestParam String name, @RequestParam String description, @RequestParam String price, @RequestPart(value = "image") MultipartFile file, HttpServletResponse response) {
        ProductDTO product = new ProductDTO();
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        product = Mapper.map(enterpriseService.updateProduct(product, file), ProductDTO.class);

        if (product != null) {
            return new ResponseBestore(200, "Product updated", product);
        } else {
            response.setStatus(404);
            return new ResponseBestore(404, "Product not found", null);
        }
    }

    @DeleteMapping(value = "/deleteProduct/{code}", produces = "application/json")
    public ResponseBestore deleteProduct(@PathVariable String code, HttpServletResponse response) {
        if (enterpriseService.deleteProduct(code)) {
            return new ResponseBestore(200, "Product deleted", null);
        } else {
            response.setStatus(404);
            return new ResponseBestore(404, "Product not found", null);
        }
    }
}
