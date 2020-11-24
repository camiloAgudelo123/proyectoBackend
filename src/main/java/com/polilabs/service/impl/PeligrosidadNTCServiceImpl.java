package com.polilabs.service.impl;

import com.polilabs.models.entity.PeligrosidadNTC;
import com.polilabs.models.repository.IPeligrosidadNTCRepository;
import com.polilabs.service.iface.IPeligrosidadNTCService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PeligrosidadNTCServiceImpl implements IPeligrosidadNTCService {

    @Autowired
    private IPeligrosidadNTCRepository peligrosidadNtcRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        PeligrosidadNTC response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = peligrosidadNtcRepository.findById(id).orElse(null);
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

        List<PeligrosidadNTC> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<PeligrosidadNTC>) peligrosidadNtcRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<PeligrosidadNTC>>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> update(int id, PeligrosidadNTC requestApi) {
        PeligrosidadNTC response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = peligrosidadNtcRepository.findById(id).orElse(null);
            if (null != response) {
                response.setCodigo(requestApi.getCodigo());
                response.setDescripcion(requestApi.getDescripcion());
                response.setImagen(requestApi.getImagen());
                peligrosidadNtcRepository.save(response);
            } else {
                responseError.put("message", "El id ingresado no existe");
                return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PeligrosidadNTC>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(PeligrosidadNTC requestApi) {
        Map<String, Object> responseError = new HashMap<>();
        PeligrosidadNTC response = null;
        try {
            response = peligrosidadNtcRepository.save(requestApi);
        } catch (Exception e) {
            responseError.put("message", "Error en la creacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PeligrosidadNTC>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<PeligrosidadNTC> drop = peligrosidadNtcRepository.findById(id);
            if (drop.isPresent()) {
                peligrosidadNtcRepository.delete(drop.get());
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
