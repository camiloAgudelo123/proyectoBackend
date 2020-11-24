
package com.polilabs.service.iface;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.RiesgosQuimicoPeligro;
import org.springframework.http.ResponseEntity;


public interface IRiesgosQuimicosPeligroService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, RiesgosQuimicoPeligro requestApi);
    ResponseEntity<?> create(RiesgosQuimicoPeligro requestApi );
    ResponseEntity<?> delete(int id);
}
