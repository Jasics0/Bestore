package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.web.transfer.dto.user.UserDTO;
import com.unillanos.software3.bestore.web.transfer.responses.AuthenticationResponse;

public interface AuthService {
    public AuthenticationResponse register(UserDTO request);

    public AuthenticationResponse login(UserDTO request);


}
