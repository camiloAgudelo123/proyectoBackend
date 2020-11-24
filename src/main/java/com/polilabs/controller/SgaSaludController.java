package com.polilabs.controller;

import com.polilabs.models.entity.SgaFisico;
import com.polilabs.models.entity.SgaSalud;
import com.polilabs.service.iface.ISgaFisicoService;
import com.polilabs.service.iface.ISgaSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgasalud")
@CrossOrigin
public class SgaSaludController {
    @Autowired
    private ISgaSaludService sgaSaludService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return sgaSaludService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return sgaSaludService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SgaSalud requestApi){
        return sgaSaludService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody SgaSalud requestApi){
        return sgaSaludService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return sgaSaludService.delete(id);
    }
}
