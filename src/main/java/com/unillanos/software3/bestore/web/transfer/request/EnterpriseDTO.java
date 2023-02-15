package com.unillanos.software3.bestore.web.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDTO {

    private Long id;
    private String nit;
    private String name;
    private String location;
    private String imagePath;
    private String phone;
    private PersonDTO person;
    private UserDTO user;

}
