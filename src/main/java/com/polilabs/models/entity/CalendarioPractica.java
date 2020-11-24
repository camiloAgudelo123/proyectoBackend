package com.polilabs.models.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calendario_practica")
public class CalendarioPractica {

    @Id
    @Column(name = "id_calendario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incrementar
    private int idCalendario;

    @Column(name = "fecha_practica")
    private LocalDate fechaPractica;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.EAGER)//Relacion de 1 a muchos
    @JoinColumn(name = "usuario_id_usuario")//Se une la columna
    private Usuario idUsuarioFk;

    @ManyToOne(fetch = FetchType.EAGER)//Relacion de 1 a muchos
    @JoinColumn(name = "laboratorio_id_laboratorio")//Se une la columna
    private Laboratorio idLaboratorioFk;

    /**
     * @return the idCalendario
     */
    public int getIdCalendario() {
        return idCalendario;
    }

    /**
     * @param idCalendario the idCalendario to set
     */
    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }

    /**
     * @return the fechaPractica
     */
    public LocalDate getFechaPractica() {
        return fechaPractica;
    }

    /**
     * @param fechaPractica the fechaPractica to set
     */
    public void setFechaPractica(LocalDate fechaPractica) {
        this.fechaPractica = fechaPractica;
    }

    /**
     * @return the horaInicio
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return idUsuarioFk;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuarioFk = idUsuario;
    }

    /**
     * @return the idLaboratorio
     */
    public Laboratorio getIdLaboratorio() {
        return idLaboratorioFk;
    }

    /**
     * @param idLaboratorio the idLaboratorio to set
     */
    public void setIdLaboratorio(Laboratorio idLaboratorio) {
        this.idLaboratorioFk = idLaboratorio;
    }

}
