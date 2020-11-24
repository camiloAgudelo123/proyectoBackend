
package com.polilabs.service.iface;

import com.polilabs.models.entity.SgaAmbiental;
import org.springframework.http.ResponseEntity;


public interface ISgaAmbientalService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, SgaAmbiental requestApi);
    ResponseEntity<?> create(SgaAmbiental requestApi );
    ResponseEntity<?> delete(int id);
}
