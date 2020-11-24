package com.polilabs.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "frases_h")
public class FrasesH {

    @Id
    @Column(name = "codigo_hp")
    private int codigoHp;

    @Column(name = "nombre_frases_hp")
    private String nombreFrasesHp;
    
    @Column(name = "descripcion")
    private String descripcion;

    /**
     * @return the codigoHp
     */
    public int getCodigoHp() {
        return codigoHp;
    }

    /**
     * @param codigoHp the codigoHp to set
     */
    public void setCodigoHp(int codigoHp) {
        this.codigoHp = codigoHp;
    }

    /**
     * @return the nombreFrasesHp
     */
    public String getNombreFrasesHp() {
        return nombreFrasesHp;
    }

    /**
     * @param nombreFrasesHp the nombreFrasesHp to set
     */
    public void setNombreFrasesHp(String nombreFrasesHp) {
        this.nombreFrasesHp = nombreFrasesHp;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    

}
