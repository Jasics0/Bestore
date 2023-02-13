package com.unillanos.software3.bestore.web.transfer.dto.enterprise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsByNameDTO {
    private String enterpriseNit;
    private String enterpriseName;
    private String enterprisePhone;
    private String productCode;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String imagePath;
}
