package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.domain.model.entities.User;
import com.unillanos.software3.bestore.web.transfer.dto.user.UserDTO;
import com.unillanos.software3.bestore.web.transfer.request.LastStepRequest;
import com.unillanos.software3.bestore.web.transfer.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    public AuthenticationResponse register(UserDTO request);

    public AuthenticationResponse login(UserDTO request, HttpServletResponse response);

    public boolean lastStep(LastStepRequest request, HttpServletResponse response);

}
