package com.unillanos.software3.bestore.web.controller.customer;

import com.unillanos.software3.bestore.domain.services.interfaces.CustomerRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.costumer.CustomerDTO;
import com.unillanos.software3.bestore.web.transfer.mapper.Mapper;
import com.unillanos.software3.bestore.web.transfer.request.PersonDTO;
import com.unillanos.software3.bestore.web.transfer.responses.ResponseBestore;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/costumer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepoService costumerService;


    @GetMapping(value = "/me", produces = "application/json")
    public ResponseBestore me(HttpServletResponse response) {
        CustomerDTO customer = Mapper.map(costumerService.me(), CustomerDTO.class);
        if (customer != null) {
            return new ResponseBestore(200, "Customer retrieved", customer);
        } else {
            response.setStatus(404);
            return new ResponseBestore(404, "Customer not found", null);
        }
    }

    @PutMapping(value = "/update", produces = "application/json")
    public ResponseBestore update(@RequestBody PersonDTO person, HttpServletResponse response){
        CustomerDTO customer= Mapper.map(costumerService.updateCostumer(person),CustomerDTO.class);
        if (customer != null) {
            return new ResponseBestore(200, "Customer updated", customer);
        } else {
            response.setStatus(404);
            return new ResponseBestore(404, "Customer not found", null);
        }
    }
}
