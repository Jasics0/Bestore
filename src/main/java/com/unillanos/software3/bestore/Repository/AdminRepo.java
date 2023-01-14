package com.unillanos.software3.bestore.Repository;

import com.unillanos.software3.bestore.model.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {


}
