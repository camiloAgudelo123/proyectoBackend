
package com.polilabs.models.repository;

import com.polilabs.models.entity.ProductoPractica;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQuery;


public interface IProductoPracticaRepository extends CrudRepository<ProductoPractica,Integer>{

    @Query(value="delete from producto_practica pp where pp.calendario_id_calendario=:id" , nativeQuery = true)
    void removeIdCalendario(@Param("id") int id);
    
}
