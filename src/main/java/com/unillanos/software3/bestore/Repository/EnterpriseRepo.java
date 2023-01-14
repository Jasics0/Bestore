package com.unillanos.software3.bestore.Repository;

import com.unillanos.software3.bestore.model.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepo extends JpaRepository<Enterprise,Long> {
}
