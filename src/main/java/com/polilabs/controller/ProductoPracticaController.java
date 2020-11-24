
package com.polilabs.controller;

import com.polilabs.models.entity.ProductoPractica;
import com.polilabs.models.entity.SgaFisico;
import com.polilabs.service.iface.IProductoPracticaService;
import com.polilabs.service.iface.ISgaFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productopractica")
@CrossOrigin
public class ProductoPracticaController {
    @Autowired
    private IProductoPracticaService productoPracticaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return productoPracticaService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return productoPracticaService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductoPractica requestApi){
        return productoPracticaService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody ProductoPractica requestApi){
        return productoPracticaService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return productoPracticaService.delete(id);
    }
}
