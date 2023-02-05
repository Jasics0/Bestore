package com.unillanos.software3.bestore.web.controller.site;

import com.unillanos.software3.bestore.model.entities.User;
import com.unillanos.software3.bestore.services.interfaces.UserRepoService;
import com.unillanos.software3.bestore.web.controller.transfer.dto.user.UserDTO;
import com.unillanos.software3.bestore.web.controller.transfer.responses.ResponseBestore;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/site")
public class LoginController {

    @Autowired
    private UserRepoService userService;

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseBestore register(@RequestBody UserDTO user, HttpServletResponse response) {
        try {
            return new ResponseBestore(200,"Usuario Registrado",userService.saveUser(user));
        }catch (Exception e){
            response.setStatus(500);
            return new ResponseBestore(500,e.getMessage(),null);
        }
    }

    @GetMapping("/get_user")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }


}
