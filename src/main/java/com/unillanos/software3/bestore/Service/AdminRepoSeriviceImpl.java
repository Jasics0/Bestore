package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.Repository.AdminRepo;
import com.unillanos.software3.bestore.model.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRepoSeriviceImpl implements AdminRepoService{

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin AdminById(Long id) {
        return adminRepo.findById(id).get();
    }

    @Override
    public Admin UpdateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public boolean DeleteAdmin(Long id) {
        try {
            adminRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
