package com.encuestas.data.model;

import javax.persistence.*;

import com.encuestas.data.bean.EmpresaBean;

import java.util.Date;

/**
 * Created by JaxKodex on 29/11/2015.
 */
@Entity
@Table(name = "ectm_empresa")
public class Empresa {
    private Integer idEmpresa;
    private String nombre;
    private String direccion;
    private Date feCreaRegistro;
    private String idCreaRegistro;

    public Empresa(Integer id, String nombre, String direccion, Date feCreaRegistro, String idCreaRegistro) {
        this.idEmpresa = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.feCreaRegistro = feCreaRegistro;
        this.idCreaRegistro = idCreaRegistro;
    }

    public Empresa(){
    }
    
    public Empresa (EmpresaBean empresaBean) {
    	this.idEmpresa = empresaBean.getIdEmpresa();
    	this.nombre = empresaBean.getNombre();
    	this.direccion = empresaBean.getDireccion();
    	this.feCreaRegistro = empresaBean.getFeCreaRegistro();
    	this.idCreaRegistro = empresaBean.getIdCreaRegistro();
    }
    
    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer id) {
        this.idEmpresa = id;
    }

    @Column(name = "de_empresa")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "de_direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "fe_crea_registro")
    public Date getFeCreaRegistro() {
        return feCreaRegistro;
    }

    public void setFeCreaRegistro(Date feCreaRegistro) {
        this.feCreaRegistro = feCreaRegistro;
    }

    @Column(name = "id_crea_registro")
    public String getIdCreaRegistro() {
        return idCreaRegistro;
    }

    public void setIdCreaRegistro(String idCreaRegistro) {
        this.idCreaRegistro = idCreaRegistro;
    }
}
