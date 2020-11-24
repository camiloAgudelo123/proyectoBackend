package com.polilabs.service.impl;

import com.polilabs.models.entity.Usuario;
import com.polilabs.models.repository.IUsuariosRepository;
import com.polilabs.service.iface.IUsuarioService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuariosRepository usuarioRepository;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Usuario user = null;
        Map<String,Object> responseError = new HashMap<>();
        try{
            user = usuarioRepository.findById(id).orElse(null);
        }catch (Exception e){
            responseError.put("message","Error consultando la informacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(user == null){
            responseError.put("message","El usuario con el id "+id.toString()+" no existe");
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> usuarios() {
        List<Usuario> usuariosEncontrados = null;
        Map<String,Object> responseError = new HashMap<>();
        try{
            usuariosEncontrados = (List<Usuario>) usuarioRepository.findAll();
        }catch (Exception e){
            responseError.put("message","Error consultando la informacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(usuariosEncontrados, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, Usuario usuario) {
        Usuario existUsuario = null;
        Map<String,Object> responseError = new HashMap<>();
        try{
            existUsuario = usuarioRepository.findById(id).orElse(null);
            if (null != existUsuario) {
                existUsuario.setNombreUsuario(usuario.getNombreUsuario());
                existUsuario.setApellidoUsuario(usuario.getApellidoUsuario());
                existUsuario.setPerfil(usuario.getPerfil());
                existUsuario.setCorreoUsuario(usuario.getCorreoUsuario());
                existUsuario = usuarioRepository.save(existUsuario);
            }else{
                responseError.put("message","El usuario ingresado no existe");
                return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            responseError.put("message","Error consultando la informacion");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Usuario>(existUsuario,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> create(Usuario usuario) {
        Usuario user = null;
        Map<String,Object>  responseError  = new HashMap<>();
        try {
           user =  usuarioRepository.save(usuario);
        }catch (Exception e){
            responseError.put("message","Error en la creacion  del usuario");
            responseError.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Usuario>(user,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            Optional<Usuario> existUsuario = usuarioRepository.findById(id);
            if (existUsuario.isPresent()) {
                usuarioRepository.delete(existUsuario.get());
                response.put("message","Usuario eliminado exitosamente");
            }else{
                response.put("message","Error, el id de esta usuario no exite en db");
                return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            response.put("message","Error al eliminar el usuario");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
