package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.model.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminRepoService {

    public List<Admin> findAllAdmins();

    public Admin saveAdmin(Admin admin);

    public Admin AdminById(Long id);

    public Admin UpdateAdmin(Admin admin);

    public boolean DeleteAdmin(Long id);

}
