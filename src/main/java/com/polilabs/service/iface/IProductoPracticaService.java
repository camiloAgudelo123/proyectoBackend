
package com.polilabs.service.iface;

import com.polilabs.models.entity.ProductoPractica;
import org.springframework.http.ResponseEntity;


public interface IProductoPracticaService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, ProductoPractica requestApi);
    ResponseEntity<?> create(ProductoPractica requestApi );
    ResponseEntity<?> delete(int id);
}
