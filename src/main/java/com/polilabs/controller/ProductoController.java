
package com.polilabs.controller;

import com.polilabs.models.entity.Producto;
import com.polilabs.service.iface.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoController {
    @Autowired
    private IProductoService IProductoService;

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> findById(@PathVariable int idProducto){
        return IProductoService.findById(idProducto);
    }
    @GetMapping
    public ResponseEntity<?> productosEncontrados(){
        return IProductoService.productos();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto){
        return IProductoService.create(producto);
    }
    
    @PutMapping("/{idProducto}")
    public ResponseEntity<?> update(@PathVariable int idProducto,@RequestBody Producto producto){
        return IProductoService.update(idProducto, producto);
    }
    
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable int idProducto){
        return IProductoService.delete(idProducto);
    }
}
