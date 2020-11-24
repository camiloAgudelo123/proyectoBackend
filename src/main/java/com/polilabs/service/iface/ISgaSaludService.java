package com.polilabs.service.iface;

import com.polilabs.models.entity.SgaFisico;
import com.polilabs.models.entity.SgaSalud;
import org.springframework.http.ResponseEntity;

public interface ISgaSaludService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, SgaSalud requestApi);
    ResponseEntity<?> create(SgaSalud requestApi );
    ResponseEntity<?> delete(int id);
}
