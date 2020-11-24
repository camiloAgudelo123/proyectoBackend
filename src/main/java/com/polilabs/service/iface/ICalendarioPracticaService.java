
package com.polilabs.service.iface;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.ProductoPractica;
import org.springframework.http.ResponseEntity;


public interface ICalendarioPracticaService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, CalendarioPractica requestApi);
    ResponseEntity<?> create(CalendarioPractica requestApi );
    ResponseEntity<?> delete(int id);
}
