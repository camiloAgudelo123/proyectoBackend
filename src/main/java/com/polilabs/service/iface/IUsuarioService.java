
package com.polilabs.service.iface;

import com.polilabs.models.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IUsuarioService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> usuarios();
    ResponseEntity<?> update(int id, Usuario usuario);
    ResponseEntity<?> create(Usuario usuario);
    ResponseEntity<?> delete(int id);
}
