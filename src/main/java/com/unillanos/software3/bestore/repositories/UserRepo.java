package com.unillanos.software3.bestore.repositories;

import com.unillanos.software3.bestore.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

}
