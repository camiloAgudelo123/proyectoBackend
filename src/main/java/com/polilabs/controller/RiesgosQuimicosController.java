
package com.polilabs.controller;

import com.polilabs.models.entity.RiesgosQuimicos;
import com.polilabs.service.iface.IRiesgosQuimicosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riesgosquimicos")
@CrossOrigin
public class RiesgosQuimicosController {
    @Autowired
    private IRiesgosQuimicosService riesgosQuimicosService;
    
    @GetMapping
    public ResponseEntity<?> riesgosQuimicosEncontrados(){
        return riesgosQuimicosService.riesgosQuimicos();
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RiesgosQuimicos riesgosQuimicos){
        return riesgosQuimicosService.create(riesgosQuimicos);
    }
    
    @PutMapping("/{idRiesgosQuimicos}")
    public ResponseEntity<?> update(@PathVariable int idRiesgosQuimicos,@RequestBody RiesgosQuimicos riesgosQuimicos){
        return riesgosQuimicosService.update(idRiesgosQuimicos, riesgosQuimicos);
    }
    
    @DeleteMapping("/{idRiesgosQuimicos}")
    public ResponseEntity<?> delete(@PathVariable int idRiesgosQuimicos){
        return riesgosQuimicosService.delete(idRiesgosQuimicos);
    }
}
