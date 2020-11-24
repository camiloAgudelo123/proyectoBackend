package com.polilabs.models.entity;

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
@Table(name = "producto_practica")
public class ProductoPractica {

    @Id// Clave primaria
    @Column(name = "id")//columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incrementar
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)//Relacion de 1 a muchos
    @JoinColumn(name = "producto_id_producto")//Se une la columna
    private Producto idProductoFk;

    @ManyToOne(fetch = FetchType.EAGER)//Relacion de 1 a muchos
    @JoinColumn(name = "calendario_id_calendario")//Se une la columna
    private CalendarioPractica idCalendarioFk;
    
    @Column(name = "cantidad_utilizada")
    private int cantidadUtilizada;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idProductoFk
     */
    public Producto getIdProductoFk() {
        return idProductoFk;
    }

    /**
     * @param idProductoFk the idProductoFk to set
     */
    public void setIdProductoFk(Producto idProductoFk) {
        this.idProductoFk = idProductoFk;
    }

    /**
     * @return the idCalendarioFk
     */
    public CalendarioPractica getIdCalendarioFk() {
        return idCalendarioFk;
    }

    /**
     * @param idCalendarioFk the idCalendarioFk to set
     */
    public void setIdCalendarioFk(CalendarioPractica idCalendarioFk) {
        this.idCalendarioFk = idCalendarioFk;
    }

    /**
     * @return the cantidadUtilizada
     */
    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    /**
     * @param cantidadUtilizada the cantidadUtilizada to set
     */
    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

}
