
package com.polilabs.controller;

import com.polilabs.models.entity.PeligrosidadNTC;
import com.polilabs.service.iface.IPeligrosidadNTCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peligrosidadntc")
@CrossOrigin
public class PeligrosidadNTCController {
    @Autowired
    private IPeligrosidadNTCService peligrosidadNtcService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return peligrosidadNtcService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return peligrosidadNtcService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PeligrosidadNTC requestApi){
        return peligrosidadNtcService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody PeligrosidadNTC requestApi){
        return peligrosidadNtcService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return peligrosidadNtcService.delete(id);
    }
}
