package com.unillanos.software3.bestore.Controller;

import com.unillanos.software3.bestore.Service.EnterpriseRepoService;
import com.unillanos.software3.bestore.model.entities.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private EnterpriseRepoService enterpriseRepoService;

    @PostMapping("/Enterprises")
    @ResponseBody
    public List<Enterprise> obtenerUsuario() {

        return  enterpriseRepoService.findAllEnterprises();
    }

    @GetMapping("/ViewEnterprises")
    public String Enterprises(){

        return "store";
    }

    @GetMapping("/About")
    public String About(){

        return "about";
    }
    @GetMapping("/Main")
    public String Home(){

        return "main";
    }

    @GetMapping("/Login")
    public String Login(){

        return "login";
    }

    @GetMapping("/Register")
    public String Register(){

        return "register";
    }



}
