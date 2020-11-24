
package com.polilabs.service.iface;

import com.polilabs.models.entity.PeligrosidadNTC;
import org.springframework.http.ResponseEntity;


public interface IPeligrosidadNTCService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, PeligrosidadNTC requestApi);
    ResponseEntity<?> create(PeligrosidadNTC requestApi );
    ResponseEntity<?> delete(int id);
}
