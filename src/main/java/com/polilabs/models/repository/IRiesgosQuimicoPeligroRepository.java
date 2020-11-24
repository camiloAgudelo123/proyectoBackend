
package com.polilabs.models.repository;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.RiesgosQuimicoPeligro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface IRiesgosQuimicoPeligroRepository extends CrudRepository<RiesgosQuimicoPeligro,Integer> {
    @Query(value="delete from riesgos_quimicos_peligro r where r.riesgo_quimico_id_riesgo=:id" , nativeQuery = true)
    void removeIdRiesgo(@Param("id") int id);
}
