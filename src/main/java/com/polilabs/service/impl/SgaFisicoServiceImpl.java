package com.polilabs.service.impl;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.SgaFisico;
import com.polilabs.models.repository.IFrasesHRepository;
import com.polilabs.models.repository.ISgaFisicoRepository;
import com.polilabs.service.iface.IFrasesHService;
import com.polilabs.service.iface.ISgaFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SgaFisicoServiceImpl implements ISgaFisicoService {
    @Autowired
    private ISgaFisicoRepository sgaFisicoRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        SgaFisico response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = sgaFisicoRepository.findById(id).orElse(null);
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
        List<SgaFisico> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<SgaFisico>) sgaFisicoRepository.findAll(); 
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<SgaFisico>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, SgaFisico requestApi) {
        SgaFisico response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = sgaFisicoRepository.findById(id).orElse(null);
            if (null != response) {
                response.setDescripcion(requestApi.getDescripcion());
                response.setImagen(requestApi.getImagen());
                sgaFisicoRepository.save(response);
            }else{
                responseError.put("message","El id ingresado no existe");
                return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SgaFisico>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(SgaFisico requestApi) {
        Map<String,Object>  responseError  = new HashMap<>();
        SgaFisico response = null;
        try {
            response = sgaFisicoRepository.save(requestApi);
        }catch (Exception e){
            responseError.put("message","Error en la creacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SgaFisico>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            Optional<SgaFisico> drop = sgaFisicoRepository.findById(id);
            if (drop.isPresent()) {
                sgaFisicoRepository.delete(drop.get());
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
