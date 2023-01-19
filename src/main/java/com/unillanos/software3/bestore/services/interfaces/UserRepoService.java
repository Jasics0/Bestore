package com.unillanos.software3.bestore.services.interfaces;

import com.unillanos.software3.bestore.model.entities.User;
import com.unillanos.software3.bestore.web.controller.transfer.dto.user.UserDTO;

import java.util.List;

public interface UserRepoService {

    public List<User> findAllUsers();

    public User saveUser(UserDTO user);

    public User UserById(String id);

    public User UpdateUser(User user);

    public boolean DeleteUser(String id);

}
