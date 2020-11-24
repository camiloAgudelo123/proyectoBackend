
package com.polilabs.models.repository;

import com.polilabs.models.entity.RiesgosQuimicos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IRiesgosQuimicosRepository extends CrudRepository<RiesgosQuimicos, Integer>{

}
