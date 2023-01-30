package com.unillanos.software3.bestore.domain.services.interfaces;

import com.unillanos.software3.bestore.domain.model.entities.Admin;

import java.util.List;


public interface AdminRepoService {

    public List<Admin> findAllAdmins();

    public Admin saveAdmin(Admin admin);

    public Admin AdminById(Long id);

    public Admin UpdateAdmin(Admin admin);

    public boolean DeleteAdmin(Long id);

}
