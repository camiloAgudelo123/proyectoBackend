
package com.polilabs.models.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="producto")
public class Producto {
    @Id// Clave primaria
    @Column(name = "id_producto")//columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incrementar
    private int idProducto;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "composicion_quimica")
    private String composicionQuimica;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "olor")
    private String olor;
    
    @Column(name = "ph")
    private String ph;
    
    @Column(name = "punto_inflamacion")
    private String puntoInflamacion;
    
    @Column(name = "fabricante")
    private String fabricante;
    
    @Column(name = "numero_fabricante")
    private long numeroFabricante;
    
    @Column(name = "pagina_fabricante")
    private String paginaFabricante;

   /* @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "producto_id_producto")
    private List<RiesgosQuimicos> riesgosQuimicos;

    public List<RiesgosQuimicos> getRiesgosQuimicos() {
        return riesgosQuimicos;
    }

    public void setRiesgosQuimicos(List<RiesgosQuimicos> riesgosQuimicos) {
        this.riesgosQuimicos = riesgosQuimicos;
    }*/

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the composicionQuimica
     */
    public String getComposicionQuimica() {
        return composicionQuimica;
    }

    /**
     * @param composicionQuimica the composicionQuimica to set
     */
    public void setComposicionQuimica(String composicionQuimica) {
        this.composicionQuimica = composicionQuimica;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the olor
     */
    public String getOlor() {
        return olor;
    }

    /**
     * @param olor the olor to set
     */
    public void setOlor(String olor) {
        this.olor = olor;
    }

    /**
     * @return the ph
     */
    public String getPh() {
        return ph;
    }

    /**
     * @param ph the ph to set
     */
    public void setPh(String ph) {
        this.ph = ph;
    }

    /**
     * @return the puntoInflamacion
     */
    public String getPuntoInflamacion() {
        return puntoInflamacion;
    }

    /**
     * @param puntoInflamacion the puntoInflamacion to set
     */
    public void setPuntoInflamacion(String puntoInflamacion) {
        this.puntoInflamacion = puntoInflamacion;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the numeroFabricante
     */
    public long getNumeroFabricante() {
        return numeroFabricante;
    }

    /**
     * @param numeroFabricante the numeroFabricante to set
     */
    public void setNumeroFabricante(long numeroFabricante) {
        this.numeroFabricante = numeroFabricante;
    }

    /**
     * @return the paginaFabricante
     */
    public String getPaginaFabricante() {
        return paginaFabricante;
    }

    /**
     * @param paginaFabricante the paginaFabricante to set
     */
    public void setPaginaFabricante(String paginaFabricante) {
        this.paginaFabricante = paginaFabricante;
    }
    
    
    
    
}
