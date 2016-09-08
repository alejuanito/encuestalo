package com.encuestas.data.bean;

public class RolOpcionBean {
    private Integer idRol;
    private String coOpcion;
    private RolBean rol;
    private OpcionBean opcion;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getCoOpcion() {
        return coOpcion;
    }

    public void setCoOpcion(String coOpcion) {
        this.coOpcion = coOpcion;
    }

    public RolBean getRol() {
        return rol;
    }

    public void setRol(RolBean rol) {
        this.rol = rol;
    }

    public OpcionBean getOpcion() {
        return opcion;
    }

    public void setOpcion(OpcionBean opcion) {
        this.opcion = opcion;
    }

}
