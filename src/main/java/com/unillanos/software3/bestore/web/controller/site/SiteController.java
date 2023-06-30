package com.unillanos.software3.bestore.web.controller.site;

import com.unillanos.software3.bestore.domain.services.interfaces.AuthService;
import com.unillanos.software3.bestore.web.transfer.dto.user.UserDTO;
import com.unillanos.software3.bestore.web.transfer.request.LastStepRequest;
import com.unillanos.software3.bestore.web.transfer.responses.ResponseBestore;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/site")
@RequiredArgsConstructor
@Slf4j
public class SiteController {

    private final AuthService authService;

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseBestore register(@RequestBody UserDTO user, HttpServletResponse response) {
        try {
            return new ResponseBestore(200, "User registered success", authService.register(user));
        } catch (Exception e) {
            response.setStatus(401);
            return new ResponseBestore(401, e.getMessage(), null);
        }
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseBestore login(@RequestBody UserDTO user, HttpServletResponse response) {
        try {
            log.info("User login {}", user);
            log.info("Login response {}", response);
            return new ResponseBestore(HttpServletResponse.SC_FOUND, "User login success", authService.login(user, response));
        } catch (Exception e) {
            response.setStatus(401);
            return new ResponseBestore(401, "User no login", null);
        }
    }

    @PostMapping(value = "/lastStep", produces = "application/json")
    public ResponseBestore lastStep(@RequestBody LastStepRequest request, HttpServletResponse response) {
        System.out.println("entro");
        try {
            return new ResponseBestore(200, "Registration ends", authService.lastStep(request, response));
        } catch (Exception e) {
            response.setStatus(401);
            return new ResponseBestore(401, "Error in registration", null);
        }
    }


}
