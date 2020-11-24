
package com.polilabs.controller;

import com.polilabs.models.entity.SgaAmbiental;
import com.polilabs.service.iface.ISgaAmbientalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgaambiental")
@CrossOrigin
public class SgaAmbientalController {
    @Autowired
    private ISgaAmbientalService sgaAmbientalService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return sgaAmbientalService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return sgaAmbientalService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SgaAmbiental requestApi){
        return sgaAmbientalService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody SgaAmbiental requestApi){
        return sgaAmbientalService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return sgaAmbientalService.delete(id);
    }
}
