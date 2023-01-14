package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.Repository.UserRepo;
import com.unillanos.software3.bestore.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRepoServiceImpl implements UserRepoService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User UserById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User UpdateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean DeleteUser(String id) {
        try {
            userRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
