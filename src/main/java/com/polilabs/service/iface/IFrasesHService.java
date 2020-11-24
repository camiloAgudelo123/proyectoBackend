package com.polilabs.service.iface;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.Laboratorio;
import org.springframework.http.ResponseEntity;

public interface IFrasesHService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, FrasesH requestApi);
    ResponseEntity<?> create(FrasesH requestApi );
    ResponseEntity<?> delete(int id);
}
