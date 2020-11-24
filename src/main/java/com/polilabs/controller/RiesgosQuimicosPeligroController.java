
package com.polilabs.controller;

import com.polilabs.models.entity.RiesgosQuimicoPeligro;
import com.polilabs.models.entity.RiesgosQuimicos;
import com.polilabs.service.iface.IRiesgosQuimicosPeligroService;
import com.polilabs.service.iface.IRiesgosQuimicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riesgosquimicospeligro")
@CrossOrigin
public class RiesgosQuimicosPeligroController {
    @Autowired
    private IRiesgosQuimicosPeligroService riesgosQuimicosPeligroServiceService;
    
    @GetMapping
    public ResponseEntity<?> riesgosQuimicosEncontrados(){
        return riesgosQuimicosPeligroServiceService.findAll();
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RiesgosQuimicoPeligro riesgosQuimicos){
        return riesgosQuimicosPeligroServiceService.create(riesgosQuimicos);
    }
    
    @PutMapping("/{idRiesgosQuimicos}")
    public ResponseEntity<?> update(@PathVariable int idRiesgosQuimicos,@RequestBody RiesgosQuimicoPeligro riesgosQuimicos){
        return riesgosQuimicosPeligroServiceService.update(idRiesgosQuimicos, riesgosQuimicos);
    }
    
    @DeleteMapping("/{idRiesgosQuimicos}")
    public ResponseEntity<?> delete(@PathVariable int idRiesgosQuimicos){
        return riesgosQuimicosPeligroServiceService.delete(idRiesgosQuimicos);
    }
}
