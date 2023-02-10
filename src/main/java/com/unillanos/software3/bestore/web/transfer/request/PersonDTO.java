package com.unillanos.software3.bestore.web.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String id;
    private String name;
    private String lastName;
    private String phone;

}
