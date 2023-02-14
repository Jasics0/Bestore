package com.unillanos.software3.bestore.web.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String code;
    private String name;
    private String description;
    private String price;
    private String imagePath;
}
