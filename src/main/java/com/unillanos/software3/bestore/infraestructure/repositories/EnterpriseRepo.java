package com.unillanos.software3.bestore.infraestructure.repositories;


import com.unillanos.software3.bestore.domain.model.entities.Enterprise;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO;
import com.unillanos.software3.bestore.web.transfer.dto.enterprise.ProductsByNameDTO;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepo extends JpaRepository<Enterprise,Long> {

    @Query("select e.id,e.nit,e.name,e.products,e.location,e.imagePath,e.phone from Enterprise e where e.id= :id")
    public List<Object[]> enterpriseProducts(@PathParam("id") Long id);

    @Query("select new com.unillanos.software3.bestore.web.transfer.dto.enterprise.EnterpriseDescDTO(e.id,e.nit,e.name,e.imagePath,e.phone) from Enterprise e")
    public List<EnterpriseDescDTO> descEnterprise();

    @Query(value = "select e.nit,e.name,e.phone,e.products from Enterprise e where e.name like CONCAT('%',:nameEnterprise,'%')")
    public List<Object []> ProductsEnterpriseByName(@Param("nameEnterprise") String name);

    @Query(value = "select e.nit, e.name, e.phone, p.code, p.name, p.description, p.price, p.image_path from enterprises e " +
            "inner join enterprises_products ep on ep.enterprise_id=e.id inner join products p on p.id=ep.products_id" +
            " where p.name like %?1%", nativeQuery = true)
    public List<Object []>  ProductsByName(String name );




}
