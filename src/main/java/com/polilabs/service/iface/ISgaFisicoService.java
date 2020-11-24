package com.polilabs.service.iface;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.SgaFisico;
import org.springframework.http.ResponseEntity;

public interface ISgaFisicoService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, SgaFisico requestApi);
    ResponseEntity<?> create(SgaFisico requestApi );
    ResponseEntity<?> delete(int id);
}
