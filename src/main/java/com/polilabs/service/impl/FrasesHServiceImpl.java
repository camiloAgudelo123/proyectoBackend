package com.polilabs.service.impl;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.repository.IFrasesHRepository;
import com.polilabs.models.repository.ILaboratorioRepository;
import com.polilabs.service.iface.IFrasesHService;
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
public class FrasesHServiceImpl implements IFrasesHService {
    @Autowired
    private IFrasesHRepository frasesHRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        FrasesH response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = frasesHRepository.findById(id).orElse(null);
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
        List<FrasesH> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<FrasesH>) frasesHRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<FrasesH>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, FrasesH requestApi) {
        FrasesH response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = frasesHRepository.findById(id).orElse(null);
            if (null != response) {
                response.setDescripcion(requestApi.getDescripcion());
                response.setNombreFrasesHp(requestApi.getNombreFrasesHp());
                frasesHRepository.save(response);
            }else{
                responseError.put("message","El id ingresado no existe");
                return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FrasesH>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(FrasesH requestApi) {
        Map<String,Object>  responseError  = new HashMap<>();
        FrasesH response = null;
        try {
            response = frasesHRepository.save(requestApi);
        }catch (Exception e){
            responseError.put("message","Error en la creacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FrasesH>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            Optional<FrasesH> drop = frasesHRepository.findById(id);
            if (drop.isPresent()) {
                frasesHRepository.delete(drop.get());
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
