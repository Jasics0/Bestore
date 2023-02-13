package com.unillanos.software3.bestore.web.transfer.dto.costumer;

import com.unillanos.software3.bestore.web.transfer.request.PersonDTO;
import com.unillanos.software3.bestore.web.transfer.request.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    Long id;
    PersonDTO person;
    UserDTO user;
}
