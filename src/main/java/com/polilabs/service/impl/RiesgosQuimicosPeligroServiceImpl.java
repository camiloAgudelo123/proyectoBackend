
package com.polilabs.service.impl;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.entity.RiesgosQuimicoPeligro;
import com.polilabs.models.entity.Usuario;
import com.polilabs.models.repository.ICalendarioPracticaRepository;
import com.polilabs.models.repository.ILaboratorioRepository;
import com.polilabs.models.repository.IRiesgosQuimicoPeligroRepository;
import com.polilabs.models.repository.IUsuariosRepository;
import com.polilabs.service.iface.ICalendarioPracticaService;
import com.polilabs.service.iface.IRiesgosQuimicosPeligroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RiesgosQuimicosPeligroServiceImpl implements IRiesgosQuimicosPeligroService {
    @Autowired
    private IRiesgosQuimicoPeligroRepository riesgosQuimicoPeligroRepository;
    
    @Override
    public ResponseEntity<?> findById(Integer id) {
        RiesgosQuimicoPeligro response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = riesgosQuimicoPeligroRepository.findById(id).orElse(null);
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

        List<RiesgosQuimicoPeligro> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<RiesgosQuimicoPeligro>) riesgosQuimicoPeligroRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<RiesgosQuimicoPeligro>>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> update(int id, RiesgosQuimicoPeligro requestApi) {
        return new ResponseEntity<String>("Not implements", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(RiesgosQuimicoPeligro requestApi) {
        Map<String, Object> responseError = new HashMap<>();
        RiesgosQuimicoPeligro response = null;
        try {
            response = riesgosQuimicoPeligroRepository.save(requestApi);
        } catch (Exception e) {
            responseError.put("message", "Error en la creacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RiesgosQuimicoPeligro>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<RiesgosQuimicoPeligro> drop = riesgosQuimicoPeligroRepository.findById(id);
            if (drop.isPresent()) {
                riesgosQuimicoPeligroRepository.delete(drop.get());
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
