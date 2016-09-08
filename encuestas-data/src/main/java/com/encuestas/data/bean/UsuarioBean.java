package com.encuestas.data.bean;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBean {
    private Integer idUsuario;
    private String username;
    private String password;
    private String estado;
    private Boolean inAdmin;
    private String cargo;
    private ColaboradorBean colaborador;
    private PersonaBean persona;
    private EmpresaBean empresa;
    private List<UsuarioRolBean> usuarioRols;

    public UsuarioBean() {
        super();
        this.usuarioRols = new ArrayList<>();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getInAdmin() {
        return inAdmin;
    }

    public void setInAdmin(Boolean inAdmin) {
        this.inAdmin = inAdmin;
    }

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public List<UsuarioRolBean> getUsuarioRols() {
        return usuarioRols;
    }

    public void setUsuarioRols(List<UsuarioRolBean> usuarioRols) {
        this.usuarioRols = usuarioRols;
    }

    public String getCargo() {
      return cargo;
    }

    public void setCargo(String cargo) {
      this.cargo = cargo;
    }

    public ColaboradorBean getColaborador() {
      return colaborador;
    }

    public void setColaborador(ColaboradorBean colaborador) {
      this.colaborador = colaborador;
    }
}
