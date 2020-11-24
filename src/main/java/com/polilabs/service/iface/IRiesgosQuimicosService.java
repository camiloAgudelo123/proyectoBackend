
package com.polilabs.service.iface;

import com.polilabs.models.entity.RiesgosQuimicos;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IRiesgosQuimicosService {
    ResponseEntity<?> riesgosQuimicos();
    ResponseEntity<?> create (RiesgosQuimicos riesgosQuimicos);
    ResponseEntity<?> update (int id, RiesgosQuimicos riesgosQuimicos);
    ResponseEntity<?> delete (int id);
}
