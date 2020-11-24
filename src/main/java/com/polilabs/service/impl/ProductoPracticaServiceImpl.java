
package com.polilabs.service.impl;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.Laboratorio;
import com.polilabs.models.entity.Producto;
import com.polilabs.models.entity.ProductoPractica;
import com.polilabs.models.entity.Usuario;
import com.polilabs.models.repository.ICalendarioPracticaRepository;
import com.polilabs.models.repository.ILaboratorioRepository;
import com.polilabs.models.repository.IProductoPracticaRepository;
import com.polilabs.models.repository.IProductoRepository;
import com.polilabs.models.repository.IUsuariosRepository;
import com.polilabs.service.iface.IProductoPracticaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoPracticaServiceImpl implements IProductoPracticaService {
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private ICalendarioPracticaRepository calendarioPracticaRepository;
    @Autowired
    private IProductoPracticaRepository productoPracticaRepository;
    
    @Override
    public ResponseEntity<?> findById(Integer id) {
        ProductoPractica response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = productoPracticaRepository.findById(id).orElse(null);
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

        List<ProductoPractica> response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = (List<ProductoPractica>) productoPracticaRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<ProductoPractica>>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> update(int id, ProductoPractica requestApi) {
        ProductoPractica response = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            response = productoPracticaRepository.findById(id).orElse(null);
            if (null != response) {
                
                Optional<Producto> existProducto = productoRepository.findById(requestApi.getIdProductoFk().getIdProducto());
                if (existProducto.isPresent()) {
                    response.setIdProductoFk(existProducto.get());
                }else{
                    responseError.put("message", "la relacion setIdUsuarioFk no existe");
                    return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                
                Optional<CalendarioPractica> existCalendarioPractica = calendarioPracticaRepository.findById(requestApi.getIdCalendarioFk().getIdCalendario());
                if (existCalendarioPractica.isPresent()) {
                    response.setIdCalendarioFk(existCalendarioPractica.get());
                }else{
                    responseError.put("message", "la relacion setIdLaboratorioFk no existe");
                    return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                response.setCantidadUtilizada(requestApi.getCantidadUtilizada());
                
                productoPracticaRepository.save(response);
            } else {
                responseError.put("message", "El id ingresado no existe");
                return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ProductoPractica>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(ProductoPractica requestApi) {
        Map<String, Object> responseError = new HashMap<>();
        ProductoPractica response = null;
        try {
            response = productoPracticaRepository.save(requestApi);
        } catch (Exception e) {
            responseError.put("message", "Error en la creacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ProductoPractica>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<ProductoPractica> drop = productoPracticaRepository.findById(id);

            if (drop.isPresent()) {
                productoPracticaRepository.delete(drop.get());
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
