package com.polilabs.service.iface;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.FrasesP;
import org.springframework.http.ResponseEntity;

public interface IFrasesPService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, FrasesP requestApi);
    ResponseEntity<?> create(FrasesP requestApi );
    ResponseEntity<?> delete(int id);
}
