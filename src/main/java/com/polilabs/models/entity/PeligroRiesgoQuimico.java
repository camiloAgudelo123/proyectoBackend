package com.polilabs.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "riesgos_quimicos_peligro")
public class PeligroRiesgoQuimico {
    @Id
    @Column(name = "id_peligro_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPeligroProducto;

    @ManyToOne
    @JoinColumn(name = "riesgo_quimico_id_riesgo")
    private RiesgosQuimicos idRiesgo;

    @ManyToOne
    @JoinColumn(name = "peligro_id")
    private PeligrosidadNTC idPeligro;

    public int getIdPeligroProducto() {
        return idPeligroProducto;
    }

    public void setIdPeligroProducto(int idPeligroProducto) {
        this.idPeligroProducto = idPeligroProducto;
    }

    public RiesgosQuimicos getIdRiesgo() {
        return idRiesgo;
    }

    public void setIdRiesgo(RiesgosQuimicos idRiesgo) {
        this.idRiesgo = idRiesgo;
    }

    public PeligrosidadNTC getIdPeligro() {
        return idPeligro;
    }

    public void setIdPeligro(PeligrosidadNTC idPeligro) {
        this.idPeligro = idPeligro;
    }
}
