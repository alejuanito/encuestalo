package com.encuestas.data.model;

import javax.persistence.*;


import java.util.Date;

/**
 * Created by JaxKodex on 29/11/2015.
 */
@Entity
@Table(name = "ectc_encuesta")
public class Encuesta {
    private Integer idEncuesta;
    private Date feEncuesta;
    private Atencion atencion;
    
    private Cliente cliente;
    private Local local;
    private Integer nuCorrelativo;
    private String nuEncuesta;

    @Id
    @Column(name = "id_encuesta")
    @SequenceGenerator(name="ectc_encuesta_id_encuesta_seq", sequenceName="ectc_encuesta_id_encuesta_seq", allocationSize=1)	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectc_encuesta_id_encuesta_seq")    
    public Integer getIdEncuesta() {
		return idEncuesta;
	}

    public void setIdEncuesta(Integer idEncuesta) {
            this.idEncuesta = idEncuesta;
    }

    @ManyToOne
    @JoinColumn(name = "id_atencion")
    public Atencion getAtencion() {
            return atencion;
    }

    public void setAtencion(Atencion atencion) {
            this.atencion = atencion;
    }

    @Column(name = "fe_encuesta")
    public Date getFeEncuesta() {
        return feEncuesta;
    }

    public void setFeEncuesta(Date feEncuesta) {
        this.feEncuesta = feEncuesta;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "id_local")
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    @Column(name = "nu_correlativo")
    public Integer getNuCorrelativo() {
        return nuCorrelativo;
    }

    public void setNuCorrelativo(Integer nuCorrelativo) {
        this.nuCorrelativo = nuCorrelativo;
    }

    @Column(name = "nu_encuesta")
    public String getNuEncuesta() {
        return nuEncuesta;
    }

    public void setNuEncuesta(String nuEncuesta) {
        this.nuEncuesta = nuEncuesta;
    }
    
	

	
}
