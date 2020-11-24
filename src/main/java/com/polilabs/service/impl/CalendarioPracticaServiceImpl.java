
package com.polilabs.service.impl;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.entity.ProductoPractica;
import com.polilabs.models.entity.Usuario;
import com.polilabs.models.repository.ICalendarioPracticaRepository;
import com.polilabs.models.repository.ILaboratorioRepository;
import com.polilabs.models.repository.IProductoPracticaRepository;
import com.polilabs.models.repository.IUsuariosRepository;
import com.polilabs.service.iface.ICalendarioPracticaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalendarioPracticaServiceImpl implements ICalendarioPracticaService {
    @Autowired
    private ICalendarioPracticaRepository calendarioPracticaRepository;
    @Autowired
    private IUsuariosRepository usuariosRepository;
    @Autowired
    private ILaboratorioRepository laboratorioRepository;
    @Autowired
    private IProductoPracticaRepository productoPracticaRepository;
    
    @Override
    public ResponseEntity<?> findById(Integer id) {
        CalendarioPractica response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = calendarioPracticaRepository.findById(id).orElse(null);
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

        List<CalendarioPractica> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<CalendarioPractica>) calendarioPracticaRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<CalendarioPractica>>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> update(int id, CalendarioPractica requestApi) {
        CalendarioPractica response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = calendarioPracticaRepository.findById(id).orElse(null);
            if (null != response) {
                response.setFechaPractica(requestApi.getFechaPractica());
                response.setHoraInicio(requestApi.getHoraInicio());
                response.setHoraFin(requestApi.getHoraFin());
                
                Optional<Usuario> existusuario = usuariosRepository.findById(requestApi.getIdUsuario().getIdUsuario());
                if (existusuario.isPresent()) {
                    response.setIdUsuario(existusuario.get());
                }else{
                    responseError.put("message", "la relacion setIdUsuarioFk no existe");
                    return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                
                Optional<Laboratorio> existLaboratorio = laboratorioRepository.findById(requestApi.getIdLaboratorio().getIdLaboratorio());
                if (existLaboratorio.isPresent()) {
                    response.setIdLaboratorio(existLaboratorio.get());
                }else{
                    responseError.put("message", "la relacion setIdLaboratorioFk no existe");
                    return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                
                calendarioPracticaRepository.save(response);
            } else {
                responseError.put("message", "El id ingresado no existe");
                return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CalendarioPractica>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(CalendarioPractica requestApi) {
        Map<String, Object> responseError = new HashMap<>();
        CalendarioPractica response = null;
        try {
            response = calendarioPracticaRepository.save(requestApi);
        } catch (Exception e) {
            responseError.put("message", "Error en la creacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CalendarioPractica>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<CalendarioPractica> drop = calendarioPracticaRepository.findById(id);
            if (drop.isPresent()) {
                try{
                    productoPracticaRepository.removeIdCalendario(id);
                }catch (Exception e) {
                    System.out.println("No hay registros a eliminar");
                }

                calendarioPracticaRepository.delete(drop.get());
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
