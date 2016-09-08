package com.encuestas.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ectm_opcion")
public class Opcion implements Serializable {
    private String codigo;
    private String nombre;
    private String url;
    private String estado;
    private String noIcon;

    @Id
    @Column(name = "co_opcion")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "no_icon")
    public String getNoIcon() {
        return noIcon;
    }

    public void setNoIcon(String noIcon) {
        this.noIcon = noIcon;
    }

    
    
    @Column(name = "no_opcion")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "de_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "es_opcion")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
