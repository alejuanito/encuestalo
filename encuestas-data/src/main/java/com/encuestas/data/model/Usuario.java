package com.encuestas.data.model;

import com.encuestas.data.bean.UsuarioBean;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ectm_usuario")
public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idUsuario;
  private String username;
  private String password;
  private String estado;
  private Boolean inAdmin;
  private Persona persona;
  private Empresa empresa;
  private List<UsuarioRol> usuarioRol;

  public Usuario() {
    super();
  }

  public Usuario(Integer idUsuario, String username, String password, String estado,
      Boolean inAdmin, Persona persona) {
    super();
    this.idUsuario = idUsuario;
    this.username = username;
    this.password = password;
    this.estado = estado;
    this.inAdmin = inAdmin;
    this.persona = persona;
  }
  public Usuario(UsuarioBean usuarioBean) {

    this.idUsuario = usuarioBean.getIdUsuario();
    

  }

  @Id
  @Column(name = "id_usuario")
  @SequenceGenerator(name = "ectm_usuario_id_usuario_seq",
      sequenceName = "ectm_usuario_id_usuario_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ectm_usuario_id_usuario_seq")
  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  @Column(name = "no_usuario")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @ManyToOne
  @JoinColumn(name = "id_empresa")
  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  @Column(name = "de_password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "es_usuario")
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Column(name = "in_admin")
  public Boolean getInAdmin() {
    return inAdmin;
  }

  public void setInAdmin(Boolean inAdmin) {
    this.inAdmin = inAdmin;
  }

  @ManyToOne
  @JoinColumn(name = "id_persona")
  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  @OneToMany(mappedBy = "usuario")
  public List<UsuarioRol> getUsuarioRol() {
    return usuarioRol;
  }

  public void setUsuarioRol(List<UsuarioRol> usuarioRol) {
    this.usuarioRol = usuarioRol;
  }
}
