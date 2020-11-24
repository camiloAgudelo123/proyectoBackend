
package com.polilabs.controller;

import com.polilabs.models.entity.CalendarioPractica;
import com.polilabs.models.entity.ProductoPractica;
import com.polilabs.service.iface.ICalendarioPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendariopractica")
@CrossOrigin
public class CalendarioPracticaController {
    @Autowired
    private ICalendarioPracticaService calendarioPracticaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return calendarioPracticaService.findById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return calendarioPracticaService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CalendarioPractica requestApi){
        return calendarioPracticaService.create(requestApi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody CalendarioPractica requestApi){
        return calendarioPracticaService.update(id, requestApi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return calendarioPracticaService.delete(id);
    }
}
