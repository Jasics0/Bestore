package com.unillanos.software3.bestore.web.controller.transfer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseBestore {

    private int status;

    private String message;

    private Object response;

}
