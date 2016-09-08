package com.encuestas.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ectm_rol_opcion")
@IdClass(RolOpcionPK.class)
public class RolOpcion implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idRol;
  private String coOpcion;
  private Rol rol;
  private Opcion opcion;

  public RolOpcion() {
    super();
    rol = new Rol();
    opcion = new Opcion();
  }

  @Id
  @Column(name = "id_rol")
  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  @Id
  @Column(name = "co_opcion")
  public String getCoOpcion() {
    return coOpcion;
  }

  public void setCoOpcion(String coOpcion) {
    this.coOpcion = coOpcion;
  }

  @ManyToOne
  @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false,
      insertable = false, updatable = false)
  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  @ManyToOne
  @JoinColumn(name = "co_opcion", referencedColumnName = "co_opcion", nullable = false,
      insertable = false, updatable = false)
  public Opcion getOpcion() {
    return opcion;
  }

  public void setOpcion(Opcion opcion) {
    this.opcion = opcion;
  }

}
