
package com.polilabs.models.repository;

import com.polilabs.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IUsuariosRepository extends CrudRepository<Usuario, Integer> {

}
