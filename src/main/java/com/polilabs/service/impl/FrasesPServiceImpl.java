package com.polilabs.service.impl;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.FrasesP;
import com.polilabs.models.repository.IFrasesHRepository;
import com.polilabs.models.repository.IFrasesPRepository;
import com.polilabs.service.iface.IFrasesHService;
import com.polilabs.service.iface.IFrasesPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FrasesPServiceImpl implements IFrasesPService{
    @Autowired
    private IFrasesPRepository frasesPRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        FrasesP response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = frasesPRepository.findById(id).orElse(null);
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
        List<FrasesP> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<FrasesP>) frasesPRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<FrasesP>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, FrasesP requestApi) {
        FrasesP response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = frasesPRepository.findById(id).orElse(null);
            if (null != response) {
                response.setDescripcion(requestApi.getDescripcion());
                response.setNombreFrasesHp(requestApi.getNombreFrasesHp());
                frasesPRepository.save(response);
            }else{
                responseError.put("message","El id ingresado no existe");
                return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FrasesP>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(FrasesP requestApi) {
        Map<String,Object>  responseError  = new HashMap<>();
        FrasesP response = null;
        try {
            response = frasesPRepository.save(requestApi);
        }catch (Exception e){
            responseError.put("message","Error en la creacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FrasesP>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            Optional<FrasesP> drop = frasesPRepository.findById(id);
            if (drop.isPresent()) {
                frasesPRepository.delete(drop.get());
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
