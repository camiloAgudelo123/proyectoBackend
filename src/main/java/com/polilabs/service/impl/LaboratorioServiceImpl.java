package com.polilabs.service.impl;

import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.entity.Producto;
import com.polilabs.models.repository.ILaboratorioRepository;
import com.polilabs.service.iface.ILaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class LaboratorioServiceImpl implements ILaboratorioService {
    @Autowired
    private ILaboratorioRepository laboratorioRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Laboratorio response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = laboratorioRepository.findById(id).orElse(null);
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
        List<Laboratorio> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<Laboratorio>) laboratorioRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Laboratorio>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, Laboratorio requestApi) {
        Laboratorio response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = laboratorioRepository.findById(id).orElse(null);
            if (null != response) {
                response.setAula(requestApi.getAula());
                response.setNombreLaboratorio(requestApi.getNombreLaboratorio());
                response.setIdCoordinador(requestApi.getIdCoordinador());
                laboratorioRepository.save(response);
            }else{
                responseError.put("message","El id ingresado no existe");
                return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Laboratorio>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(Laboratorio requestApi) {
        Map<String,Object>  responseError  = new HashMap<>();
        Laboratorio response = null;
        try {
            response = laboratorioRepository.save(requestApi);
        }catch (Exception e){
            responseError.put("message","Error en la creacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Laboratorio>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            Optional<Laboratorio> drop = laboratorioRepository.findById(id);
            if (drop.isPresent()) {
                laboratorioRepository.delete(drop.get());
                response.put("message","eliminado exitosamente");
            }else{
                response.put("message","Error, el id  no exite en db");
                return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            response.put("message","Error al eliminar ");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
