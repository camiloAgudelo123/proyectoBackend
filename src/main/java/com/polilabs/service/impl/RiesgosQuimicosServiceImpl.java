package com.polilabs.service.impl;

import com.polilabs.models.entity.*;
import com.polilabs.models.repository.ISgaAmbientalRepository;
import com.polilabs.models.repository.ISgaFisicoRepository;
import com.polilabs.models.repository.ISgaSaludRepository;
import com.polilabs.models.repository.IFrasesHRepository;
import com.polilabs.models.repository.IFrasesPRepository;
import com.polilabs.models.repository.IPeligrosidadNTCRepository;
import com.polilabs.models.repository.IProductoRepository;
import com.polilabs.models.repository.IRiesgosQuimicosRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.polilabs.service.iface.IRiesgosQuimicosService;

@Service
public class RiesgosQuimicosServiceImpl implements IRiesgosQuimicosService {

    @Autowired
    private IRiesgosQuimicosRepository riesgosQuimicosRepository;
    @Autowired
    private IProductoRepository IProductoRepository;
    @Autowired
    private IPeligrosidadNTCRepository peligrosidadNTC1692Repository;
    @Autowired
    private IFrasesHRepository frasesHRepository;
    @Autowired
    private IFrasesPRepository IFrasesPRepository;
    @Autowired
    private ISgaAmbientalRepository sgaAmbientalRepository;
    @Autowired
    private ISgaSaludRepository sgaSaludRepository;
    @Autowired
    private ISgaFisicoRepository sgaFiscoRepository;

    @Override
    public ResponseEntity<?> riesgosQuimicos() {
        Map<String, Object> responseError = new HashMap<>();
        List<RiesgosQuimicos> listRiesgosQuimicos = null;
        try {
            listRiesgosQuimicos = (List<RiesgosQuimicos>) riesgosQuimicosRepository.findAll();
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<RiesgosQuimicos>>(listRiesgosQuimicos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(RiesgosQuimicos riesgosQuimicos) {
        Map<String, Object> responseError = new HashMap<>();
        RiesgosQuimicos response = null;
        try {
            Optional<Producto> producto = IProductoRepository.findById(riesgosQuimicos.getIdProductoFk().getIdProducto());
            Optional<SgaAmbiental> sgaAmbiental = sgaAmbientalRepository.findById(riesgosQuimicos.getIdSGAAmbientalFk().getId());
            if (producto.isPresent()  && sgaAmbiental.isPresent() ) {
                response = riesgosQuimicosRepository.save(riesgosQuimicos);
            } else {
                responseError.put("message", "Error en la creacion  del riesgo, compruebe las claves foreanas");
                return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseError.put("message", "Error en la creacion  del producto");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RiesgosQuimicos>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(int id, RiesgosQuimicos riesgosQuimicos) {
        Map<String, Object> responseError = new HashMap<>();
        Optional<RiesgosQuimicos> existRiesgosQuimicos = null;
        try {
             existRiesgosQuimicos = riesgosQuimicosRepository.findById(id);
            if (existRiesgosQuimicos.isPresent()) {
                Optional<Producto> producto = IProductoRepository.findById(riesgosQuimicos.getIdProductoFk().getIdProducto());
                if (!(producto.isPresent())) {
                    responseError.put("message", "la relacion peligrosidadNTC no existe");
                    return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                existRiesgosQuimicos.get().setGre(riesgosQuimicos.getGre());
                existRiesgosQuimicos.get().setNumeroUn(riesgosQuimicos.getNumeroUn());
                existRiesgosQuimicos.get().setCas(riesgosQuimicos.getCas());
                existRiesgosQuimicos.get().setCancerigeno(riesgosQuimicos.getCancerigeno());
                existRiesgosQuimicos.get().setCategoriaIARC(riesgosQuimicos.getCategoriaIARC());
                existRiesgosQuimicos.get().setCategoriaACGIH(riesgosQuimicos.getCategoriaACGIH());
                existRiesgosQuimicos.get().setNfpaS(riesgosQuimicos.getNfpaS());
                existRiesgosQuimicos.get().setNfpaI(riesgosQuimicos.getNfpaI());
                existRiesgosQuimicos.get().setNfpaR(riesgosQuimicos.getNfpaR());
                existRiesgosQuimicos.get().setNfpaE(riesgosQuimicos.getNfpaE());

                Optional<SgaAmbiental> sgaAmbiental = sgaAmbientalRepository.findById(riesgosQuimicos.getIdSGAAmbientalFk().getId());

                if (sgaAmbiental.isPresent() ) {
                    existRiesgosQuimicos.get().setIdSGAAmbientalFk(sgaAmbiental.get());
                } else {
                    responseError.put("message", "la relacion setIdSGAFisicoFk no existe");
                    return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                existRiesgosQuimicos.get().setReactividad(riesgosQuimicos.getReactividad());
                existRiesgosQuimicos.get().setEstabilidadQuimica(riesgosQuimicos.getEstabilidadQuimica());
                existRiesgosQuimicos.get().setReaccionesPeligrosas(riesgosQuimicos.getReaccionesPeligrosas());
                existRiesgosQuimicos.get().setSustanciasIncompatibles(riesgosQuimicos.getSustanciasIncompatibles());
                existRiesgosQuimicos.get().setTwa(riesgosQuimicos.getTwa());
                existRiesgosQuimicos.get().setStell(riesgosQuimicos.getStell());
                existRiesgosQuimicos.get().setTlvC(riesgosQuimicos.getTlvC());
                existRiesgosQuimicos.get().setPeligroInhalacion(riesgosQuimicos.getPeligroInhalacion());
                existRiesgosQuimicos.get().setPeligroIngestion(riesgosQuimicos.getPeligroIngestion());
                existRiesgosQuimicos.get().setPeligroPiel(riesgosQuimicos.getPeligroPiel());
                existRiesgosQuimicos.get().setPeligroOjos(riesgosQuimicos.getPeligroOjos());
                existRiesgosQuimicos.get().setEfectosCronicos(riesgosQuimicos.getEfectosCronicos());
                existRiesgosQuimicos.get().setMedidasRespiratorias(riesgosQuimicos.getMedidasRespiratorias());
                existRiesgosQuimicos.get().setMedidasManos(riesgosQuimicos.getMedidasManos());
                existRiesgosQuimicos.get().setMedidasOjos(riesgosQuimicos.getMedidasOjos());
                existRiesgosQuimicos.get().setMedidasPiel(riesgosQuimicos.getMedidasPiel());
                existRiesgosQuimicos.get().setMedidasHigiene(riesgosQuimicos.getMedidasHigiene());
                existRiesgosQuimicos.get().setMedidasControlIng(riesgosQuimicos.getMedidasControlIng());
                existRiesgosQuimicos.get().setMedidasAlmacenamiento(riesgosQuimicos.getMedidasAlmacenamiento());
                existRiesgosQuimicos.get().setMedidasManipulacion(riesgosQuimicos.getMedidasManipulacion());
                existRiesgosQuimicos.get().setPrAuxInhalacion(riesgosQuimicos.getPrAuxInhalacion());
                existRiesgosQuimicos.get().setPrAuxIngestion(riesgosQuimicos.getPrAuxIngestion());
                existRiesgosQuimicos.get().setPrAuxPiel(riesgosQuimicos.getPrAuxPiel());
                existRiesgosQuimicos.get().setPrAuxOjos(riesgosQuimicos.getPrAuxOjos());
                existRiesgosQuimicos.get().setPrAuxOtras(riesgosQuimicos.getPrAuxOtras());
                existRiesgosQuimicos.get().setPeligroEspIncendio(riesgosQuimicos.getPeligroEspIncendio());
                existRiesgosQuimicos.get().setPeligroEspSalud(riesgosQuimicos.getPeligroEspSalud());
                existRiesgosQuimicos.get().setRecomendacionIncendio(riesgosQuimicos.getRecomendacionIncendio());
                existRiesgosQuimicos.get().setAgenteExtintor(riesgosQuimicos.getAgenteExtintor());
                existRiesgosQuimicos.get().setCtrolProctecFuga(riesgosQuimicos.getCtrolProctecFuga());
                existRiesgosQuimicos.get().setCtrolLimpieza(riesgosQuimicos.getCtrolLimpieza());
                existRiesgosQuimicos.get().setFichaSeguridad(riesgosQuimicos.getFichaSeguridad());
                existRiesgosQuimicos.get().setTarjetaEmergencia(riesgosQuimicos.getTarjetaEmergencia());
                existRiesgosQuimicos.get().setPalabraEmergencia(riesgosQuimicos.getPalabraEmergencia());
                existRiesgosQuimicos.get().setImagen(riesgosQuimicos.getImagen());
                riesgosQuimicosRepository.save(existRiesgosQuimicos.get());

            }
        } catch (Exception e) {
            responseError.put("message", "Error consultando la informacion");
            responseError.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Optional<RiesgosQuimicos>>(existRiesgosQuimicos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<RiesgosQuimicos> existRiesgosQuimicos = riesgosQuimicosRepository.findById(id);
            if (existRiesgosQuimicos.isPresent()) {
                riesgosQuimicosRepository.delete(existRiesgosQuimicos.get());
                response.put("message","riesgo eliminado exitosamente");
            }else{
                response.put("message","Error, el id de esta riesgo no exite en db");
                return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            response.put("message", "Error al eliminar el riesgo");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
