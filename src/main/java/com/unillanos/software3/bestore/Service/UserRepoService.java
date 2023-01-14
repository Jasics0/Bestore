package com.unillanos.software3.bestore.Service;

import com.unillanos.software3.bestore.model.entities.Product;
import com.unillanos.software3.bestore.model.entities.User;

import java.util.List;

public interface UserRepoService {

    public List<User> findAllUsers();

    public User saveUser(User user);

    public User UserById(String id);

    public User UpdateUser(User user);

    public boolean DeleteUser(String id);

}
