package com.polilabs.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "riesgos_quimicos_peligro")
public class RiesgosQuimicoPeligro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peligro_producto")
    private int idPeligroProducto;

    @Column(name = "riesgo_quimico_id_riesgo")
    private int fkRiesgo;
    
    @Column(name = "peligro_id")
    private int fkPeligro;

    public int getIdPeligroProducto() {
        return idPeligroProducto;
    }

    public void setIdPeligroProducto(int idPeligroProducto) {
        this.idPeligroProducto = idPeligroProducto;
    }

    public int getFkRiesgo() {
        return fkRiesgo;
    }

    public void setFkRiesgo(int fkRiesgo) {
        this.fkRiesgo = fkRiesgo;
    }

    public int getFkPeligro() {
        return fkPeligro;
    }

    public void setFkPeligro(int fkPeligro) {
        this.fkPeligro = fkPeligro;
    }
}
