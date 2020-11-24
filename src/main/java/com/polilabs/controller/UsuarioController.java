
package com.polilabs.controller;

import com.polilabs.models.entity.Usuario;
import com.polilabs.service.iface.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private IUsuarioService IUsuarioService;
    
    @GetMapping
    public ResponseEntity<?> usuariosEncontrados(){
        return IUsuarioService.usuarios();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> update(@PathVariable Integer idUsuario){
        return  IUsuarioService.findById(idUsuario);
    }
    @PostMapping
    public  ResponseEntity<?> create(@RequestBody Usuario usuario){
        return IUsuarioService.create(usuario);
    }
    
    @PutMapping("/{idUsuario}")
    public  ResponseEntity<?> update(@PathVariable int idUsuario,@RequestBody Usuario usuario){
        return IUsuarioService.update(idUsuario, usuario);
    }
    
    @DeleteMapping("/{idUsuario}")
    public  ResponseEntity<?> delete(@PathVariable int idUsuario){
        return IUsuarioService.delete(idUsuario);
    }
}
