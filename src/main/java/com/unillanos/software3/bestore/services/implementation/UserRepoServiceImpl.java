package com.unillanos.software3.bestore.services.implementation;

import com.unillanos.software3.bestore.model.enums.Role;
import com.unillanos.software3.bestore.repositories.UserRepo;
import com.unillanos.software3.bestore.model.entities.User;
import com.unillanos.software3.bestore.services.interfaces.UserRepoService;
import com.unillanos.software3.bestore.web.transfer.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRepoServiceImpl implements UserRepoService {

    private final UserRepo userRepo;

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(UserDTO user) {
        User userEntity = new User();

        userEntity.setEmail(user.getEmail());

        if (user.getPassword().length()<8){
            throw new IllegalArgumentException("La monda excepcion");
        }else{
            userEntity.setPassword(user.getPassword());
        }

        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            userEntity.setRole(Role.ADMIN);
        } else if (user.getRole().equalsIgnoreCase("ENTERPRISE")) {
            userEntity.setRole(Role.ENTERPRISE);
        } else {
            userEntity.setRole(Role.USER);
        }
        return userRepo.save(userEntity);
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
        } catch (Exception err) {
            return false;
        }
    }
}
