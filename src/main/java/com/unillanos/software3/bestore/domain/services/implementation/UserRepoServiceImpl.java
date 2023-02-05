package com.unillanos.software3.bestore.domain.services.implementation;

import com.unillanos.software3.bestore.domain.model.entities.User;
import com.unillanos.software3.bestore.domain.model.enums.Role;
import com.unillanos.software3.bestore.infraestructure.repositories.UserRepo;
import com.unillanos.software3.bestore.domain.services.interfaces.UserRepoService;
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
            throw new IllegalArgumentException("Longitud de constraseña invalida (Mayor que 8 caracteres)");
        }else{
            userEntity.setPassword(user.getPassword());
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
