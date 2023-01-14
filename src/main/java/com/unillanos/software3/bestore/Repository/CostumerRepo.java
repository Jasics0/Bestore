package com.unillanos.software3.bestore.Repository;

import com.unillanos.software3.bestore.model.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepo extends JpaRepository<Costumer, Long> {
}
