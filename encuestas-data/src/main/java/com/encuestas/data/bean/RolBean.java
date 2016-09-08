package com.encuestas.data.bean;

import java.util.ArrayList;
import java.util.List;

public class RolBean {
    private Integer idRol;
    private String nombre;
    private String estado;
    private List<RolOpcionBean> rolOpciones;

    public RolBean() {
        super();
        rolOpciones = new ArrayList<>();
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<RolOpcionBean> getRolOpciones() {
        return rolOpciones;
    }

    public void setRolOpciones(List<RolOpcionBean> rolOpciones) {
        this.rolOpciones = rolOpciones;
    }

}
