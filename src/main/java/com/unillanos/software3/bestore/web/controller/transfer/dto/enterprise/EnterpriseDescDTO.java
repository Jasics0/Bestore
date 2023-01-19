package com.unillanos.software3.bestore.web.controller.transfer.dto.enterprise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseDescDTO {
    private Long id;
    private String nit;
    private String name;
    private String imagePath;
    private String phone;

}
