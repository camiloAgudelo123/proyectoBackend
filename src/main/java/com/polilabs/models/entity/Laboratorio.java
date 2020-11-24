
package com.polilabs.models.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    @Column(name = "id_laboratorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incrementar
    private int idLaboratorio;

    @Column(name = "nombre_laboratorio")
    private String nombreLaboratorio;

    @Column(name = "aula")
    private String aula;

    @Column(name = "id_coordinador")
    private int idCoordinador;

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    /**
     * @return the idLaboratorio
     */
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     * @param idLaboratorio the idLaboratorio to set
     */
    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * @return the nombreLaboratorio
     */
    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    /**
     * @param nombreLaboratorio the nombreLaboratorio to set
     */
    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    /**
     * @return the aula
     */
    public String getAula() {
        return aula;
    }

    /**
     * @param aula the aula to set
     */
    public void setAula(String aula) {
        this.aula = aula;
    }
}
