package com.polilabs.controller;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.SgaFisico;
import com.polilabs.service.iface.IFrasesHService;
import com.polilabs.service.iface.ISgaFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgafisico")
@CrossOrigin
public class SgaFisicoController {
    @Autowired
    private ISgaFisicoService sgaFisicoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return sgaFisicoService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return sgaFisicoService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SgaFisico requestApi){
        return sgaFisicoService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody SgaFisico requestApi){
        return sgaFisicoService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return sgaFisicoService.delete(id);
    }
}
