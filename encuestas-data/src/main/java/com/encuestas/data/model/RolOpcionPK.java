package com.encuestas.data.model;

import java.io.Serializable;

public class RolOpcionPK implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer idRol;
  private String coOpcion;

  public RolOpcionPK() {
    super();
  }

  public RolOpcionPK(Integer idRol, String coOpcion) {
    super();
    this.idRol = idRol;
    this.coOpcion = coOpcion;
  }

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
}
