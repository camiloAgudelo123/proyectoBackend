package com.polilabs.controller;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.Laboratorio;
import com.polilabs.service.iface.IFrasesHService;
import com.polilabs.service.iface.ILaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frasesh")
@CrossOrigin
public class FrasesHController {
    @Autowired
    private IFrasesHService frasesHService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return frasesHService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return frasesHService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FrasesH requestApi){
        return frasesHService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody FrasesH requestApi){
        return frasesHService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return frasesHService.delete(id);
    }
}
