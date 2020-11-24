package com.polilabs.service.impl;

import com.polilabs.models.entity.SgaAmbiental;
import com.polilabs.models.repository.ISgaAmbientalRepository;
import com.polilabs.service.iface.ISgaAmbientalService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class SgaAmbientalServiceImpl implements ISgaAmbientalService {

    @Autowired
    private ISgaAmbientalRepository sgaAmbientalRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        SgaAmbiental response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = sgaAmbientalRepository.findById(id).orElse(null);
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (response == null) {
            responseError.put("message", "El  id " + id.toString() + " no existe");
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<SgaAmbiental> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<SgaAmbiental>) sgaAmbientalRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<SgaAmbiental>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, SgaAmbiental requestApi) {
        SgaAmbiental response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = sgaAmbientalRepository.findById(id).orElse(null);
            if (null != response) {
                response.setDescripcion(requestApi.getDescripcion());
                response.setImagen(requestApi.getImagen());
                sgaAmbientalRepository.save(response);
            } else {
                responseError.put("message", "El id ingresado no existe");
                return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SgaAmbiental>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> create(SgaAmbiental requestApi) {
        Map<String, Object> responseError = new HashMap<>();
        SgaAmbiental response = null;
        try {
            response = sgaAmbientalRepository.save(requestApi);
        } catch (Exception e) {
            responseError.put("message", "Error en la creacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SgaAmbiental>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<SgaAmbiental> drop = sgaAmbientalRepository.findById(id);
            if (drop.isPresent()) {
                sgaAmbientalRepository.delete(drop.get());
                response.put("message", "eliminado exitosamente");
            } else {
                response.put("message", "Error, el id  no exite en db");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            response.put("message", "Error al eliminar ");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
