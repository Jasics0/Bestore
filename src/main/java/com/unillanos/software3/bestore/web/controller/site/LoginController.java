package com.unillanos.software3.bestore.web.controller.site;

import com.unillanos.software3.bestore.domain.model.entities.User;
import com.unillanos.software3.bestore.domain.services.interfaces.AuthService;
import com.unillanos.software3.bestore.domain.services.interfaces.UserRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.user.UserDTO;
import com.unillanos.software3.bestore.web.transfer.responses.ResponseBestore;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/site")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseBestore register(@RequestBody UserDTO user, HttpServletResponse response) {
        try {
            return new ResponseBestore(200,"User registered success",authService.register(user));
        }catch (Exception e){
            response.setStatus(500);
            return new ResponseBestore(500,"User no registered",null);
        }
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseBestore login(@RequestBody UserDTO user, HttpServletResponse response) {
        try {
            return new ResponseBestore(200,"User login success",authService.login(user));
        }catch (Exception e){
            response.setStatus(500);
            return new ResponseBestore(500,"User no login",null);
        }
    }


}
