
package com.polilabs.service.iface;

import com.polilabs.models.entity.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IProductoService {
    ResponseEntity<?> findById(Integer id);
    ResponseEntity<?> productos();
    ResponseEntity<?> update(int id, Producto producto);
    ResponseEntity<?> create(Producto producto );
    ResponseEntity<?> delete(int id);
}
