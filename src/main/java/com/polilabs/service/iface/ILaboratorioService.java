package com.polilabs.service.iface;

import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.entity.Producto;
import org.springframework.http.ResponseEntity;

public interface ILaboratorioService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(int id, Laboratorio requestApi);
    ResponseEntity<?> create(Laboratorio requestApi );
    ResponseEntity<?> delete(int id);
}
