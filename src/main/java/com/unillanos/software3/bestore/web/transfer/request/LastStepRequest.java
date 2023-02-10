package com.unillanos.software3.bestore.web.transfer.request;

import lombok.Data;

@Data
public class LastStepRequest {
    private String username;
    private EnterpriseDTO enterprise;
    private PersonDTO person;
}
