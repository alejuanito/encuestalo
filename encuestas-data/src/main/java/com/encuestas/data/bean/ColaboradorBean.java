package com.encuestas.data.bean;

public class ColaboradorBean {
  private Integer idColaborador;
  private PersonaBean persona;
  private LocalBean local;
  private UsuarioBean usuario;
  private CargoColaboradorBean cargoColaboradorBean;

  public Integer getIdColaborador() {
    return idColaborador;
  }

  public void setIdColaborador(Integer idColaborador) {
    this.idColaborador = idColaborador;
  }

  public PersonaBean getPersona() {
    return persona;
  }

  public void setPersona(PersonaBean persona) {
    this.persona = persona;
  }

  public LocalBean getLocal() {
    return local;
  }

  public void setLocal(LocalBean local) {
    this.local = local;
  }

  public UsuarioBean getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioBean usuario) {
    this.usuario = usuario;
  }

  public CargoColaboradorBean getCargoColaboradorBean() {
    return cargoColaboradorBean;
  }

  public void setCargoColaboradorBean(CargoColaboradorBean cargoColaboradorBean) {
    this.cargoColaboradorBean = cargoColaboradorBean;
  }
}
