package com.encuestas.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class UsuarioRolPK implements Serializable {
    private Integer idUsuario;
    private Integer idRol;

    @Id
    @Column(name = "id_usuario")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Id
    @Column(name = "id_rol")
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
