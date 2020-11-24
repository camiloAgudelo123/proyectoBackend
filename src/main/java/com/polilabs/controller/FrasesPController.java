package com.polilabs.controller;

import com.polilabs.models.entity.FrasesH;
import com.polilabs.models.entity.FrasesP;
import com.polilabs.service.iface.IFrasesHService;
import com.polilabs.service.iface.IFrasesPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frasesp")
@CrossOrigin
public class FrasesPController {
    @Autowired
    private IFrasesPService frasesPService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return frasesPService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return frasesPService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FrasesP requestApi){
        return frasesPService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody FrasesP requestApi){
        return frasesPService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return frasesPService.delete(id);
    }
}
