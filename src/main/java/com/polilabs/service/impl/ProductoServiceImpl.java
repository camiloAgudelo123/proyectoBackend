package com.polilabs.service.impl;

import com.polilabs.models.entity.Producto;
import com.polilabs.models.entity.Usuario;
import com.polilabs.models.repository.IProductoRepository;
import com.polilabs.models.repository.IRiesgosQuimicoPeligroRepository;
import com.polilabs.service.iface.IProductoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository IProductoRepository;
    @Autowired
    private IRiesgosQuimicoPeligroRepository iRiesgosQuimicoPeligroRepository;
    @Override
    public ResponseEntity<?> findById(Integer id) {
        Producto producto = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            producto = IProductoRepository.findById(id).orElse(null);
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (producto == null) {
            responseError.put("message", "El producto con el id " + id.toString() + " no existe");
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> productos() {
        List<Producto> productosEncontrados = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            productosEncontrados = (List<Producto>) IProductoRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Producto>>(productosEncontrados, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, Producto producto) {
        Producto existProducto = null;
        Map<String, Object> responseError = new HashMap<>();
        try {
            existProducto = IProductoRepository.findById(id).orElse(null);
            if (null != existProducto) {
                existProducto.setNombre(producto.getNombre());
                existProducto.setDescripcion(producto.getDescripcion());
                existProducto.setCantidad(producto.getCantidad());
                existProducto.setEstado(producto.getEstado());
                existProducto.setComposicionQuimica(producto.getComposicionQuimica());
                existProducto.setColor(producto.getColor());
                existProducto.setOlor(producto.getOlor());
                existProducto.setPh(producto.getPh());
                existProducto.setPuntoInflamacion(producto.getPuntoInflamacion());
                existProducto.setFabricante(producto.getFabricante());
                existProducto.setNumeroFabricante(producto.getNumeroFabricante());
                existProducto.setPaginaFabricante(producto.getPaginaFabricante());
                IProductoRepository.save(existProducto);
            }else{
                responseError.put("message","El producto ingresado no existe");
                return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Producto>(existProducto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(Producto producto) {
        Map<String,Object>  responseError  = new HashMap<>();
        Producto response = null;
        try {
            response = IProductoRepository.save(producto);
        }catch (Exception e){
            responseError.put("message","Error en la creacion  del producto");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Producto>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String,Object> response = new HashMap<>();
        try {
        Optional<Producto> existProducto = IProductoRepository.findById(id);
            try {
                iRiesgosQuimicoPeligroRepository.removeIdRiesgo(id);
            }catch (Exception e){

            }
        if (existProducto.isPresent()) {
            IProductoRepository.delete(existProducto.get());
            response.put("message","producto eliminado exitosamente");
        }else{
            response.put("message","Error, el id de esta producto no exite en db");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }catch (Exception e){
            response.put("message","Error al eliminar el producto");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
