
package com.polilabs.models.repository;

import com.polilabs.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;


public interface IProductoRepository extends CrudRepository<Producto, Integer>{
    
}
