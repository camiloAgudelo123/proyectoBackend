package com.polilabs.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "riesgos_quimicos")
public class RiesgosQuimicos {

    @Id
    @Column(name = "id_riesgo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRiesgo;

    @ManyToOne
    @JoinColumn(name = "producto_id_producto")
    private Producto idProductoFk;

    @Column(name = "gre")
    private int gre;

    @Column(name = "numero_un")
    private String numeroUn;

    @Column(name = "cas")
    private String cas;

    @Column(name = "cancerigeno")
    private String cancerigeno;

    @Column(name = "categoria_iarc")
    private String categoriaIARC;

    @Column(name = "categoria_acgih")
    private String categoriaACGIH;

    @Column(name = "nfpa_s")
    private int nfpaS;

    @Column(name = "nfpa_i")
    private int nfpaI;

    @Column(name = "nfpa_r")
    private int nfpaR;

    @Column(name = "nfpa_e")
    private String nfpaE;

    @ManyToOne
    @JoinColumn(name = "sga_ambiental_id")
    private SgaAmbiental idSGAAmbientalFk;

    @Column(name = "reactividad")
    private String reactividad;

    @Column(name = "estabilidad_quimica")
    private String estabilidadQuimica;

    @Column(name = "reacciones_peligrosas")
    private String reaccionesPeligrosas;

    @Column(name = "sustancias_incompatibles")
    private String sustanciasIncompatibles;

    @Column(name = "twa")
    private String twa;

    @Column(name = "stell")
    private String stell;

    @Column(name = "tlv_c")
    private String tlvC;

    @Column(name = "peligro_inhalacion")
    private String peligroInhalacion;

    @Column(name = "peligro_ingestion")
    private String peligroIngestion;

    @Column(name = "peligro_piel")
    private String peligroPiel;

    @Column(name = "peligro_ojos")
    private String peligroOjos;

    @Column(name = "efectos_cronicos")
    private String efectosCronicos;

    @Column(name = "medidas_respiratorias")
    private String medidasRespiratorias;

    @Column(name = "medidas_manos")
    private String medidasManos;

    @Column(name = "medidas_ojos")
    private String medidasOjos;

    @Column(name = "medidas_piel")
    private String medidasPiel;

    @Column(name = "medidas_higiene")
    private String medidasHigiene;

    @Column(name = "medidas_control_ing")
    private String medidasControlIng;

    @Column(name = "medidas_almacenamiento")
    private String medidasAlmacenamiento;

    @Column(name = "medidas_manipulacion")
    private String medidasManipulacion;

    @Column(name = "pr_aux_inhalacion")
    private String prAuxInhalacion;

    @Column(name = "pr_aux_ingestion")
    private String prAuxIngestion;

    @Column(name = "pr_aux_piel")
    private String prAuxPiel;

    @Column(name = "pr_aux_ojos")
    private String prAuxOjos;

    @Column(name = "pr_aux_otras")
    private String prAuxOtras;

    @Column(name = "peligro_esp_incendio")
    private String peligroEspIncendio;

    @Column(name = "peligro_esp_salud")
    private String peligroEspSalud;

    @Column(name = "recomendacion_incendio")
    private String recomendacionIncendio;

    @Column(name = "agente_extintor")
    private String agenteExtintor;

    @Column(name = "ctrol_proctec_fuga")
    private String ctrolProctecFuga;

    @Column(name = "ctrol_limpieza")
    private String ctrolLimpieza;

    @Column(name = "ficha_seguridad")
    private String fichaSeguridad;

    @Column(name = "tarjeta_emergencia")
    private String tarjetaEmergencia;

    @Column(name = "palabra_emergencia")
    private String palabraEmergencia;

    @Column(name = "imagen")
    private String imagen;


    /*@ManyToOne
    @JoinColumn(name = "producto_id_producto")
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }*/

    /**
     * @return the idRiesgo
     */
    public int getIdRiesgo() {
        return idRiesgo;
    }

    /**
     * @param idRiesgo the idRiesgo to set
     */
    public void setIdRiesgo(int idRiesgo) {
        this.idRiesgo = idRiesgo;
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
     * @return the grie
     */
    public int getGre() {
        return gre;
    }

    /**
     * @param grie the grie to set
     */
    public void setGre(int grie) {
        this.gre = grie;
    }

    /**
     * @return the numeroUn
     */
    public String getNumeroUn() {
        return numeroUn;
    }

    /**
     * @param numeroUn the numeroUn to set
     */
    public void setNumeroUn(String numeroUn) {
        this.numeroUn = numeroUn;
    }

    /**
     * @return the gas
     */
    public String getCas() {
        return cas;
    }

    /**
     * @param cas the gas to set
     */
    public void setCas(String cas) {
        this.cas = cas;
    }

    /**
     * @return the cancerigeno
     */
    public String getCancerigeno() {
        return cancerigeno;
    }

    /**
     * @param cancerigeno the cancerigeno to set
     */
    public void setCancerigeno(String cancerigeno) {
        this.cancerigeno = cancerigeno;
    }

    /**
     * @return the categoriaIARC
     */
    public String getCategoriaIARC() {
        return categoriaIARC;
    }

    /**
     * @param categoriaIARC the categoriaIARC to set
     */
    public void setCategoriaIARC(String categoriaIARC) {
        this.categoriaIARC = categoriaIARC;
    }

    /**
     * @return the categoriaACGIH
     */
    public String getCategoriaACGIH() {
        return categoriaACGIH;
    }

    /**
     * @param categoriaACGIH the categoriaACGIH to set
     */
    public void setCategoriaACGIH(String categoriaACGIH) {
        this.categoriaACGIH = categoriaACGIH;
    }

    /**
     * @return the nfpaS
     */
    public int getNfpaS() {
        return nfpaS;
    }

    /**
     * @param nfpaS the nfpaS to set
     */
    public void setNfpaS(int nfpaS) {
        this.nfpaS = nfpaS;
    }

    /**
     * @return the nfpaI
     */
    public int getNfpaI() {
        return nfpaI;
    }

    /**
     * @param nfpaI the nfpaI to set
     */
    public void setNfpaI(int nfpaI) {
        this.nfpaI = nfpaI;
    }

    /**
     * @return the nfpaR
     */
    public int getNfpaR() {
        return nfpaR;
    }

    /**
     * @param nfpaR the nfpaR to set
     */
    public void setNfpaR(int nfpaR) {
        this.nfpaR = nfpaR;
    }

    /**
     * @return the nfpaE
     */
    public String getNfpaE() {
        return nfpaE;
    }

    /**
     * @param nfpaE the nfpaE to set
     */
    public void setNfpaE(String nfpaE) {
        this.nfpaE = nfpaE;
    }

    /**
     * @return the idSGAAmbientalFk
     */
    public SgaAmbiental getIdSGAAmbientalFk() {
        return idSGAAmbientalFk;
    }

    /**
     * @param idSGAAmbientalFk the idSGAAmbientalFk to set
     */
    public void setIdSGAAmbientalFk(SgaAmbiental idSGAAmbientalFk) {
        this.idSGAAmbientalFk = idSGAAmbientalFk;
    }

    /**
     * @return the reactividad
     */
    public String getReactividad() {
        return reactividad;
    }

    /**
     * @param reactividad the reactividad to set
     */
    public void setReactividad(String reactividad) {
        this.reactividad = reactividad;
    }

    /**
     * @return the estabilidadQuimica
     */
    public String getEstabilidadQuimica() {
        return estabilidadQuimica;
    }

    /**
     * @param estabilidadQuimica the estabilidadQuimica to set
     */
    public void setEstabilidadQuimica(String estabilidadQuimica) {
        this.estabilidadQuimica = estabilidadQuimica;
    }

    /**
     * @return the reaccionesPeligrosas
     */
    public String getReaccionesPeligrosas() {
        return reaccionesPeligrosas;
    }

    /**
     * @param reaccionesPeligrosas the reaccionesPeligrosas to set
     */
    public void setReaccionesPeligrosas(String reaccionesPeligrosas) {
        this.reaccionesPeligrosas = reaccionesPeligrosas;
    }

    /**
     * @return the sustanciasIncompatibles
     */
    public String getSustanciasIncompatibles() {
        return sustanciasIncompatibles;
    }

    /**
     * @param sustanciasIncompatibles the sustanciasIncompatibles to set
     */
    public void setSustanciasIncompatibles(String sustanciasIncompatibles) {
        this.sustanciasIncompatibles = sustanciasIncompatibles;
    }

    /**
     * @return the twa
     */
    public String getTwa() {
        return twa;
    }

    /**
     * @param twa the twa to set
     */
    public void setTwa(String twa) {
        this.twa = twa;
    }

    /**
     * @return the stell
     */
    public String getStell() {
        return stell;
    }

    /**
     * @param stell the stell to set
     */
    public void setStell(String stell) {
        this.stell = stell;
    }

    /**
     * @return the tlvC
     */
    public String getTlvC() {
        return tlvC;
    }

    /**
     * @param tlvC the tlvC to set
     */
    public void setTlvC(String tlvC) {
        this.tlvC = tlvC;
    }

    /**
     * @return the peligroInhalacion
     */
    public String getPeligroInhalacion() {
        return peligroInhalacion;
    }

    /**
     * @param peligroInhalacion the peligroInhalacion to set
     */
    public void setPeligroInhalacion(String peligroInhalacion) {
        this.peligroInhalacion = peligroInhalacion;
    }

    /**
     * @return the peligroIngestion
     */
    public String getPeligroIngestion() {
        return peligroIngestion;
    }

    /**
     * @param peligroIngestion the peligroIngestion to set
     */
    public void setPeligroIngestion(String peligroIngestion) {
        this.peligroIngestion = peligroIngestion;
    }

    /**
     * @return the peligroPiel
     */
    public String getPeligroPiel() {
        return peligroPiel;
    }

    /**
     * @param peligroPiel the peligroPiel to set
     */
    public void setPeligroPiel(String peligroPiel) {
        this.peligroPiel = peligroPiel;
    }

    /**
     * @return the peligroOjos
     */
    public String getPeligroOjos() {
        return peligroOjos;
    }

    /**
     * @param peligroOjos the peligroOjos to set
     */
    public void setPeligroOjos(String peligroOjos) {
        this.peligroOjos = peligroOjos;
    }

    /**
     * @return the efectosCronicos
     */
    public String getEfectosCronicos() {
        return efectosCronicos;
    }

    /**
     * @param efectosCronicos the efectosCronicos to set
     */
    public void setEfectosCronicos(String efectosCronicos) {
        this.efectosCronicos = efectosCronicos;
    }

    /**
     * @return the medidasRespiratorias
     */
    public String getMedidasRespiratorias() {
        return medidasRespiratorias;
    }

    /**
     * @param medidasRespiratorias the medidasRespiratorias to set
     */
    public void setMedidasRespiratorias(String medidasRespiratorias) {
        this.medidasRespiratorias = medidasRespiratorias;
    }

    /**
     * @return the medidasManos
     */
    public String getMedidasManos() {
        return medidasManos;
    }

    /**
     * @param medidasManos the medidasManos to set
     */
    public void setMedidasManos(String medidasManos) {
        this.medidasManos = medidasManos;
    }

    /**
     * @return the medidasOjos
     */
    public String getMedidasOjos() {
        return medidasOjos;
    }

    /**
     * @param medidasOjos the medidasOjos to set
     */
    public void setMedidasOjos(String medidasOjos) {
        this.medidasOjos = medidasOjos;
    }

    /**
     * @return the medidasPiel
     */
    public String getMedidasPiel() {
        return medidasPiel;
    }

    /**
     * @param medidasPiel the medidasPiel to set
     */
    public void setMedidasPiel(String medidasPiel) {
        this.medidasPiel = medidasPiel;
    }

    /**
     * @return the medidasHigiene
     */
    public String getMedidasHigiene() {
        return medidasHigiene;
    }

    /**
     * @param medidasHigiene the medidasHigiene to set
     */
    public void setMedidasHigiene(String medidasHigiene) {
        this.medidasHigiene = medidasHigiene;
    }

    /**
     * @return the medidasControlIng
     */
    public String getMedidasControlIng() {
        return medidasControlIng;
    }

    /**
     * @param medidasControlIng the medidasControlIng to set
     */
    public void setMedidasControlIng(String medidasControlIng) {
        this.medidasControlIng = medidasControlIng;
    }

    /**
     * @return the medidasAlmacenamiento
     */
    public String getMedidasAlmacenamiento() {
        return medidasAlmacenamiento;
    }

    /**
     * @param medidasAlmacenamiento the medidasAlmacenamiento to set
     */
    public void setMedidasAlmacenamiento(String medidasAlmacenamiento) {
        this.medidasAlmacenamiento = medidasAlmacenamiento;
    }

    /**
     * @return the medidasManipulacion
     */
    public String getMedidasManipulacion() {
        return medidasManipulacion;
    }

    /**
     * @param medidasManipulacion the medidasManipulacion to set
     */
    public void setMedidasManipulacion(String medidasManipulacion) {
        this.medidasManipulacion = medidasManipulacion;
    }

    /**
     * @return the prAuxInhalaciom
     */
    public String getPrAuxInhalacion() {
        return prAuxInhalacion;
    }

    /**
     * @param prAuxInhalaciom the prAuxInhalaciom to set
     */
    public void setPrAuxInhalacion(String prAuxInhalaciom) {
        this.prAuxInhalacion = prAuxInhalaciom;
    }

    /**
     * @return the prAuxIngestion
     */
    public String getPrAuxIngestion() {
        return prAuxIngestion;
    }

    /**
     * @param prAuxIngestion the prAuxIngestion to set
     */
    public void setPrAuxIngestion(String prAuxIngestion) {
        this.prAuxIngestion = prAuxIngestion;
    }

    /**
     * @return the prAuxPiel
     */
    public String getPrAuxPiel() {
        return prAuxPiel;
    }

    /**
     * @param prAuxPiel the prAuxPiel to set
     */
    public void setPrAuxPiel(String prAuxPiel) {
        this.prAuxPiel = prAuxPiel;
    }

    /**
     * @return the prAuxOjos
     */
    public String getPrAuxOjos() {
        return prAuxOjos;
    }

    /**
     * @param prAuxOjos the prAuxOjos to set
     */
    public void setPrAuxOjos(String prAuxOjos) {
        this.prAuxOjos = prAuxOjos;
    }

    /**
     * @return the prAuxOtras
     */
    public String getPrAuxOtras() {
        return prAuxOtras;
    }

    /**
     * @param prAuxOtras the prAuxOtras to set
     */
    public void setPrAuxOtras(String prAuxOtras) {
        this.prAuxOtras = prAuxOtras;
    }

    /**
     * @return the peligroEspIncendio
     */
    public String getPeligroEspIncendio() {
        return peligroEspIncendio;
    }

    /**
     * @param peligroEspIncendio the peligroEspIncendio to set
     */
    public void setPeligroEspIncendio(String peligroEspIncendio) {
        this.peligroEspIncendio = peligroEspIncendio;
    }

    /**
     * @return the peligroEspSalud
     */
    public String getPeligroEspSalud() {
        return peligroEspSalud;
    }

    /**
     * @param peligroEspSalud the peligroEspSalud to set
     */
    public void setPeligroEspSalud(String peligroEspSalud) {
        this.peligroEspSalud = peligroEspSalud;
    }

    /**
     * @return the recomendacionIncendio
     */
    public String getRecomendacionIncendio() {
        return recomendacionIncendio;
    }

    /**
     * @param recomendacionIncendio the recomendacionIncendio to set
     */
    public void setRecomendacionIncendio(String recomendacionIncendio) {
        this.recomendacionIncendio = recomendacionIncendio;
    }

    /**
     * @return the agenteExtintor
     */
    public String getAgenteExtintor() {
        return agenteExtintor;
    }

    /**
     * @param agenteExtintor the agenteExtintor to set
     */
    public void setAgenteExtintor(String agenteExtintor) {
        this.agenteExtintor = agenteExtintor;
    }

    /**
     * @return the ctrolProctecFuga
     */
    public String getCtrolProctecFuga() {
        return ctrolProctecFuga;
    }

    /**
     * @param ctrolProctecFuga the ctrolProctecFuga to set
     */
    public void setCtrolProctecFuga(String ctrolProctecFuga) {
        this.ctrolProctecFuga = ctrolProctecFuga;
    }

    /**
     * @return the ctrolLimpieza
     */
    public String getCtrolLimpieza() {
        return ctrolLimpieza;
    }

    /**
     * @param ctrolLimpieza the ctrolLimpieza to set
     */
    public void setCtrolLimpieza(String ctrolLimpieza) {
        this.ctrolLimpieza = ctrolLimpieza;
    }

    /**
     * @return the fichaSeguridad
     */
    public String getFichaSeguridad() {
        return fichaSeguridad;
    }

    /**
     * @param fichaSeguridad the fichaSeguridad to set
     */
    public void setFichaSeguridad(String fichaSeguridad) {
        this.fichaSeguridad = fichaSeguridad;
    }

    /**
     * @return the tarjetaEmergencia
     */
    public String getTarjetaEmergencia() {
        return tarjetaEmergencia;
    }

    /**
     * @param tarjetaEmergencia the tarjetaEmergencia to set
     */
    public void setTarjetaEmergencia(String tarjetaEmergencia) {
        this.tarjetaEmergencia = tarjetaEmergencia;
    }

    /**
     * @return the palabraEmergencia
     */
    public String getPalabraEmergencia() {
        return palabraEmergencia;
    }

    /**
     * @param palabraEmergencia the palabraEmergencia to set
     */
    public void setPalabraEmergencia(String palabraEmergencia) {
        this.palabraEmergencia = palabraEmergencia;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
